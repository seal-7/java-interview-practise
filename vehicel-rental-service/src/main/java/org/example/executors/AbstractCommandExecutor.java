package org.example.executors;

import org.example.enums.ServiceError;
import org.example.exceptions.AbstractServiceException;
import org.example.exceptions.InvalidCommandException;
import org.example.exceptions.ResourceAlreadyExistsException;
import org.example.exceptions.ResourceNotFoundException;
import org.example.models.Command;

public abstract class AbstractCommandExecutor {

    public String COMMAND_NAME;

    public AbstractCommandExecutor(String commandName) {
        COMMAND_NAME = commandName;
    }

    protected void validateCommandName(Command command) throws InvalidCommandException {
        if (!COMMAND_NAME.equals(command.getCommandName())) {
            throw new InvalidCommandException(ServiceError.COMMAND_NAME_MISMATCH_ERROR);
        }
    }

    public abstract void validate(Command command) throws AbstractServiceException;
    public abstract void execute(Command command) throws AbstractServiceException;
}
