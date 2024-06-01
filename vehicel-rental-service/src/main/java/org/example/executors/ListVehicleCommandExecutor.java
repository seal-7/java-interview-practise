package org.example.executors;

import org.example.constants.CommandConstants;
import org.example.exceptions.AbstractServiceException;
import org.example.models.Branch;
import org.example.models.Command;
import org.example.models.Vehicle;
import org.example.services.BranchManagementService;
import org.example.services.SlotBookingService;
import org.example.utils.OutputPrinter;

import java.util.ArrayList;
import java.util.List;

public class ListVehicleCommandExecutor extends AbstractCommandExecutor {

    private final BranchManagementService branchManagementService;
    private final SlotBookingService slotBookingService;
    public ListVehicleCommandExecutor(BranchManagementService branchManagementService,
                                      SlotBookingService slotBookingService) {
        super(CommandConstants.LIST_VEHICLE_COMMAND_NAME);
        this.branchManagementService = branchManagementService;
        this.slotBookingService = slotBookingService;
    }

    @Override
    public void validate(Command command) throws AbstractServiceException {

    }

    @Override
    public void execute(Command command) throws AbstractServiceException {
        List<String> args = command.getArgs();
        String branchName = args.get(0);
        Integer startingSlotHour = Integer.parseInt(args.get(1));
        Integer duration = Integer.parseInt(args.get(2));
        Branch branch = branchManagementService.getBranch(branchName);
        List<Integer> availabilityWindow = getAvailabilityWindow(startingSlotHour, duration);
        List<Vehicle> availableVehicles = slotBookingService.getAvailableVehicle(branch, availabilityWindow);
        OutputPrinter.printVehicles(availableVehicles);
    }

    private List<Integer> getAvailabilityWindow(Integer startingSlotHour, Integer duration) {
        List<Integer> window = new ArrayList<>();

        for(int i=startingSlotHour; i<(startingSlotHour+duration) && i< 24; i++) {
            window.add(i);
        }
        return window;
    }
}
