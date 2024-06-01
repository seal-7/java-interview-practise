package org.example.mode;

import org.example.enums.ServiceError;
import org.example.exceptions.AbstractServiceException;
import org.example.exceptions.ServiceIOException;
import org.example.executors.AbstractCommandExecutor;
import org.example.factory.CommandExecutorFactory;
import org.example.models.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends AbstractMode {
    public InteractiveMode(CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void processInput() throws AbstractServiceException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while(true) {
            try {
                String input = bufferedReader.readLine();
                Command command = new Command(input);
                AbstractCommandExecutor commandExecutor = getCommandExecutor(command);
                commandExecutor.validate(command);
                commandExecutor.execute(command);
            } catch (IOException e) {
                throw new ServiceIOException(ServiceError.INPUT_READ_ERROR);
            }

        }
    }
}
