package org.example.factory;

import org.example.enums.ServiceError;
import org.example.exceptions.ResourceNotFoundException;
import org.example.executors.*;
import org.example.services.BranchManagementService;
import org.example.services.SlotBookingService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    final Map<String, AbstractCommandExecutor> commandExecutorMap;

    public CommandExecutorFactory(BranchManagementService branchManagementService,
                                  SlotBookingService slotBookingService) {
        Map<String, AbstractCommandExecutor> map = new HashMap<>();
        AddVehicleCommandExecutor addVehicleCommandExecutor = new AddVehicleCommandExecutor(branchManagementService, slotBookingService);
        AddBranchCommandExecutor addBranchCommandExecutor = new AddBranchCommandExecutor(branchManagementService, slotBookingService);
        ListVehicleCommandExecutor listVehicleCommandExecutor = new ListVehicleCommandExecutor(branchManagementService, slotBookingService);
        RentVehicleCommandExecutor rentVehicleCommandExecutor = new RentVehicleCommandExecutor(branchManagementService, slotBookingService);
        map.put(addVehicleCommandExecutor.COMMAND_NAME, addVehicleCommandExecutor);
        map.put(addBranchCommandExecutor.COMMAND_NAME, addBranchCommandExecutor);
        map.put(listVehicleCommandExecutor.COMMAND_NAME, listVehicleCommandExecutor);
        map.put(rentVehicleCommandExecutor.COMMAND_NAME, rentVehicleCommandExecutor);
        this.commandExecutorMap = map;
    }

    public AbstractCommandExecutor getInstance(String commandName) throws ResourceNotFoundException {
        if (!commandExecutorMap.containsKey(commandName)) {
            throw new ResourceNotFoundException(ServiceError.COMMAND_NAME_MISMATCH_ERROR);
        }
        return commandExecutorMap.get(commandName);
    }
}
