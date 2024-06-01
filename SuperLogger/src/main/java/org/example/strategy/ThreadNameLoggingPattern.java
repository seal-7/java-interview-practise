package org.example.strategy;

import org.example.models.Log;

import java.util.Date;

public class ThreadNameLoggingPattern implements LoggingPatternStrategy {
    public ThreadNameLoggingPattern() {
    }

    @Override
    public String getFormattedLog(Log log) {
        return String.format("%s %s %s %s", new Date(log.getTimestamp()), Thread.currentThread().getName(), log.getLogLevel().getName(), log.getMessage());
    }
}
