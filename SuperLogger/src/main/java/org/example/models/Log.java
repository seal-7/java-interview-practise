package org.example.models;

import org.example.enums.LogLevel;

public class Log {
    String message;
    LogLevel logLevel;
    long timestamp;

    public Log(String message, LogLevel logLevel, long timestamp) {
        this.message = message;
        this.logLevel = logLevel;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
