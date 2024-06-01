package org.example.services.sync;

import org.example.enums.LogLevel;
import org.example.models.Log;
import org.example.services.SuperLogger;
import org.example.sniks.Sink;
import org.example.sniks.StdoutSink;
import org.example.strategy.DefaultLoggingPattern;

public class SyncSuperLogger extends SuperLogger {
    public SyncSuperLogger(Sink sink) {
        super(sink);
    }

    @Override
    public void debug(String input) {
        Log log = new Log(input, LogLevel.DEBUG, System.currentTimeMillis());
        getSink().writeLog(log);
    }

    @Override
    public void info(String input) {
        Log log = new Log(input, LogLevel.INFO, System.currentTimeMillis());
        getSink().writeLog(log);
    }

    @Override
    public void warn(String input) {
        Log log = new Log(input, LogLevel.WARN, System.currentTimeMillis());
        getSink().writeLog(log);
    }

    @Override
    public void error(String input) {
        Log log = new Log(input, LogLevel.ERROR, System.currentTimeMillis());
        getSink().writeLog(log);
    }

    @Override
    public void fatal(String input) {
        Log log = new Log(input, LogLevel.FATAL, System.currentTimeMillis());
        getSink().writeLog(log);
    }
}
