package org.example.executors;

import org.example.constants.CommandConstants;
import org.example.enums.VehicleType;
import org.example.exceptions.AbstractServiceException;
import org.example.models.Branch;
import org.example.models.Command;
import org.example.services.BranchManagementService;
import org.example.services.SlotBookingService;

import java.util.ArrayList;
import java.util.List;

public class RentVehicleCommandExecutor extends  AbstractCommandExecutor {

    final BranchManagementService branchManagementService;
    final SlotBookingService slotBookingService;
    public RentVehicleCommandExecutor(BranchManagementService branchManagementService, SlotBookingService slotBookingService) {
        super(CommandConstants.RENT_VEHICLE_COMMAND_NAME);
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
        String vehicleType = args.get(1);
        Integer startingSlot = Integer.parseInt(args.get(2));
        Integer duration = Integer.parseInt(args.get(3));
        List<Integer> availabilityWindow = getAvailabilityWindow(startingSlot, duration);
        Branch branch = branchManagementService.getBranch(branchName);
        slotBookingService.bookVehicle(branch, VehicleType.getVehicleType(vehicleType), availabilityWindow);
    }

    private List<Integer> getAvailabilityWindow(Integer startingSlotHour, Integer duration) {
        List<Integer> window = new ArrayList<>();

        for(int i=startingSlotHour; i<(startingSlotHour+duration) && i< 24; i++) {
            window.add(i);
        }
        return window;
    }
}
