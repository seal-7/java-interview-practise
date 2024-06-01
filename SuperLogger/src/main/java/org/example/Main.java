package org.example;

import org.example.enums.LogLevel;
import org.example.enums.LoggingPattern;
import org.example.services.SuperLogger;
import org.example.services.async.AsyncSuperLogger;
import org.example.services.sync.SyncSuperLogger;
import org.example.sniks.Sink;
import org.example.sniks.StdoutSink;
import org.example.strategy.LoggingPatternFactory;
import org.example.strategy.LoggingPatternStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        testSyncLogDebugLevel();
        testSyncLogWarnLevel();

        testAsyncLogDebug();

    }

    public static void testSyncLogDebugLevel() {
        LoggingPatternFactory loggingPatternFactory = new LoggingPatternFactory();
        LoggingPatternStrategy loggingPatternStrategy = loggingPatternFactory.getInstance(LoggingPattern.DEFAULT);
        Sink sink = new StdoutSink(loggingPatternStrategy, LogLevel.DEBUG);
        SuperLogger logger = new SyncSuperLogger(sink);
        logger.debug("Debug log");
        logger.info("Info debug");
        logger.warn("Warn debug");
        logger.error("Error debug");
        logger.fatal("Fatal debug");
    }

    public static void testSyncLogWarnLevel() {
        LoggingPatternFactory loggingPatternFactory = new LoggingPatternFactory();
        LoggingPatternStrategy loggingPatternStrategy = loggingPatternFactory.getInstance(LoggingPattern.DEFAULT);
        Sink sink = new StdoutSink(loggingPatternStrategy, LogLevel.WARN);
        SuperLogger logger = new SyncSuperLogger(sink);
        logger.debug("Debug log");
        logger.info("Info debug");
        logger.warn("Warn debug");
        logger.error("Error debug");
        logger.fatal("Fatal debug");
    }

    public static void testAsyncLogDebug() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        LoggingPatternFactory loggingPatternFactory = new LoggingPatternFactory();
        LoggingPatternStrategy loggingPatternStrategy = loggingPatternFactory.getInstance(LoggingPattern.THREAD_NAME);
        Sink sink = new StdoutSink(loggingPatternStrategy, LogLevel.DEBUG);
        SuperLogger logger = new AsyncSuperLogger(sink, threadPoolExecutor, 10000);
        for(int i=0; i<1000;i++) {
            Thread thread = new Thread(() -> {
                logger.debug("Debug log " + Thread.currentThread().getName());
                logger.info("Info debug");
                logger.warn("Warn debug");
                logger.error("Error debug");
                logger.fatal("Fatal debug");
            });
            thread.start();
        }

    }
}