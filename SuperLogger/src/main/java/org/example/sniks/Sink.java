package org.example.sniks;

import org.example.enums.LogLevel;
import org.example.models.Log;
import org.example.strategy.LoggingPatternStrategy;

public abstract class Sink {

    final LoggingPatternStrategy loggingPatternStrategy;
    final LogLevel configuredLogLevel;

    protected Sink(LoggingPatternStrategy loggingPatternStrategy, LogLevel configuredLogLevel) {
        this.loggingPatternStrategy = loggingPatternStrategy;
        this.configuredLogLevel = configuredLogLevel;
    }


    public abstract void writeLog(Log log);

    protected Boolean shouldWriteLog(LogLevel processingLogLevel, LogLevel configuredLogLevel) {
        return (processingLogLevel.getValue() >= configuredLogLevel.getValue());
    }
}
