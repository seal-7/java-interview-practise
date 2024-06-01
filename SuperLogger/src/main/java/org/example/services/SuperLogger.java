package org.example.services;

import org.example.enums.LogLevel;
import org.example.sniks.Sink;

public abstract class SuperLogger {
    private final Sink sink;

    protected SuperLogger(Sink sink) {
        this.sink = sink;
    }

    public abstract void debug(String input);
    public abstract void info(String input);
    public abstract void warn(String input);
    public abstract void error(String input);
    public abstract void fatal(String input);


    protected Sink getSink() {
        return sink;
    }
}
