package org.example;

import org.example.exceptions.AbstractServiceException;
import org.example.factory.CommandExecutorFactory;
import org.example.mode.AbstractMode;
import org.example.mode.InteractiveMode;
import org.example.services.BranchManagementService;
import org.example.services.SlotBookingService;
import org.example.strategy.LowestPriceReservationStrategy;
import org.example.strategy.VehicleReservationStrategy;

public class Main {
    public static void main(String[] args) {
        VehicleReservationStrategy vehicleReservationStrategy = new LowestPriceReservationStrategy();
        SlotBookingService slotBookingService = new SlotBookingService(vehicleReservationStrategy);
        BranchManagementService branchManagementService = new BranchManagementService();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(branchManagementService, slotBookingService);
        AbstractMode inputMode = new InteractiveMode(commandExecutorFactory);
        try {
            inputMode.processInput();
        } catch (AbstractServiceException e) {
            System.out.printf("ErrorCode: %s, ErrorMessage: %s%n", e.getError().getErrorCode(),
                    e.getError().getErrorMessage());
        }
    }
}