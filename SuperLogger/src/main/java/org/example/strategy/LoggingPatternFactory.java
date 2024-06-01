package org.example.strategy;

import org.example.enums.LoggingPattern;

import java.util.HashMap;
import java.util.Map;

public class LoggingPatternFactory {
    Map<LoggingPattern, LoggingPatternStrategy> loggingPatternStrategyMap;

    public LoggingPatternFactory() {
        Map<LoggingPattern, LoggingPatternStrategy> mp = new HashMap<>();
        mp.put(LoggingPattern.DEFAULT, new DefaultLoggingPattern());
        mp.put(LoggingPattern.THREAD_NAME, new ThreadNameLoggingPattern());
        this.loggingPatternStrategyMap = mp;
    }

    public LoggingPatternStrategy getInstance(LoggingPattern loggingPattern) {
        return loggingPatternStrategyMap.get(loggingPattern);
    }
}
