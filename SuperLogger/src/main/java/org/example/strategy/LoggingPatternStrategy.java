package org.example.strategy;

import org.example.models.Log;

public interface LoggingPatternStrategy {

    public String getFormattedLog(Log log);

}
