package org.example.mode;

import org.example.exceptions.AbstractServiceException;
import org.example.exceptions.ResourceNotFoundException;
import org.example.exceptions.ServiceIOException;
import org.example.executors.AbstractCommandExecutor;
import org.example.factory.CommandExecutorFactory;
import org.example.models.Command;

public abstract class AbstractMode {

    final CommandExecutorFactory commandExecutorFactory;

    protected AbstractMode(CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
    }

    public abstract void processInput() throws AbstractServiceException;

    protected AbstractCommandExecutor getCommandExecutor(final Command command) throws ResourceNotFoundException {
        return commandExecutorFactory.getInstance(command.getCommandName());
    }
}
