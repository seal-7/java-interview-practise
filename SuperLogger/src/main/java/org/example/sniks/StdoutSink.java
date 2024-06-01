package org.example.sniks;

import org.example.enums.LogLevel;
import org.example.models.Log;
import org.example.strategy.LoggingPatternStrategy;

public class StdoutSink extends Sink {
    public StdoutSink(LoggingPatternStrategy loggingPatternStrategy, LogLevel configuredLogLevel) {
        super(loggingPatternStrategy, configuredLogLevel);
    }

    @Override
    public void writeLog(Log log) {
        String output = loggingPatternStrategy.getFormattedLog(log);
        if (shouldWriteLog(log.getLogLevel(), configuredLogLevel)) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(output);
        }
    }
}
