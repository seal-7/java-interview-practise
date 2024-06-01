package org.example.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private final String commandName;
    private final List<String> args;

    public Command(String input) {
        List<String> parsedInput = Arrays.stream(input.split(" ")).toList();
        commandName = parsedInput.get(0);
        args = parsedInput.subList(1, parsedInput.size());
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getArgs() {
        return args;
    }
}
