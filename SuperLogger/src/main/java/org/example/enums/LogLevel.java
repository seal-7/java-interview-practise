package org.example.enums;

public enum LogLevel {
    DEBUG("DEBUG", 1),
    INFO("INFO", 2),
    WARN("WARN", 3),
    ERROR("ERROR", 4),
    FATAL("FATAL", 5);

    LogLevel(String name, int value) {
        this.value = value;
        this.name = name;
    }
    private final int value;
    private final String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
