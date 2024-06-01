package org.example.services.async;

import org.example.enums.LogLevel;
import org.example.enums.ServiceError;
import org.example.exceptions.BufferException;
import org.example.models.Log;
import org.example.services.SuperLogger;
import org.example.sniks.Sink;
import org.example.sniks.StdoutSink;
import org.example.strategy.DefaultLoggingPattern;
import org.example.strategy.ThreadNameLoggingPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static org.example.utils.PartitioningUtil.assignPartitionNumber;

public class AsyncSuperLogger extends SuperLogger {
    final ThreadPoolExecutor executor;
    List<PriorityBlockingQueue<Log>> queues;

    private final int bufferSize;
    public AsyncSuperLogger(Sink sink, ThreadPoolExecutor executor, int bufferSize) {
        super(sink);
        this.executor = executor;
        this.bufferSize = bufferSize/executor.getMaximumPoolSize();
        initialiseBuffer(executor.getMaximumPoolSize());
        startConsumers();
    }

    private void initialiseBuffer(int bufferPartition) {
        queues = new ArrayList<>();
        for (int i=0; i<bufferPartition; i++) {
            PriorityBlockingQueue<Log> partition = new PriorityBlockingQueue<>(bufferSize, (l1,l2) -> Math.toIntExact(l1.getTimestamp() - l2.getTimestamp()));
            queues.add(partition);
        }
    }

    @Override
    public void debug(String input) {
        Log log = new Log(input, LogLevel.DEBUG, System.currentTimeMillis());
        producer(log);
    }

    @Override
    public void info(String input) {
        Log log = new Log(input, LogLevel.INFO, System.currentTimeMillis());
        producer(log);
    }

    @Override
    public void warn(String input) {
        Log log = new Log(input, LogLevel.WARN, System.currentTimeMillis());
        producer(log);
    }

    @Override
    public void error(String input) {
        Log log = new Log(input, LogLevel.ERROR, System.currentTimeMillis());
        producer(log);
    }

    @Override
    public void fatal(String input) {
        Log log = new Log(input, LogLevel.FATAL, System.currentTimeMillis());
        producer(log);
    }

    private synchronized void producer(Log log) {
        int partitionNumber = assignPartitionNumber(queues.size());
        if (queues.get(partitionNumber).size() >= bufferSize) {
          throw new BufferException(ServiceError.BUFFER_SIZE_FULL);
        }
        queues.get(partitionNumber).add(log);
    }

    private void startConsumers() {
        for (int i=0; i<queues.size(); i++) {
            int partitionIndex = i;
            Thread consumerThread = new Thread(()->{
                while (true) {
                    if(queues.get(partitionIndex).size() > 0) {
                        Log log = queues.get(partitionIndex).poll();
                        getSink().writeLog(log);
                    }
                }
            });
            consumerThread.start();
        }
    }
}
