package org.example.strategy;

import org.example.models.Log;

import java.util.Date;

public class DefaultLoggingPattern implements LoggingPatternStrategy {
    public DefaultLoggingPattern() {
    }

    @Override
    public String getFormattedLog(Log log) {
        return String.format("%s %s %s", new Date(log.getTimestamp()), log.getLogLevel().getName(), log.getMessage());
    }
}
