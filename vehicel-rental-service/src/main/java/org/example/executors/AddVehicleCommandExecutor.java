package org.example.executors;

import org.example.constants.CommandConstants;
import org.example.enums.ServiceError;
import org.example.enums.VehicleType;
import org.example.exceptions.AbstractServiceException;
import org.example.exceptions.ResourceNotFoundException;
import org.example.models.Branch;
import org.example.models.Command;
import org.example.models.Vehicle;
import org.example.services.BranchManagementService;
import org.example.services.SlotBookingService;

import java.util.List;

public class AddVehicleCommandExecutor extends AbstractCommandExecutor {
    final BranchManagementService branchManagementService;
    final SlotBookingService slotBookingService;
    public AddVehicleCommandExecutor(BranchManagementService branchManagementService,
                                     SlotBookingService slotBookingService) {
        super(CommandConstants.ADD_VEHICLE_COMMAND_NAME);
        this.branchManagementService = branchManagementService;
        this.slotBookingService = slotBookingService;
    }

    @Override
    public void validate(Command command) throws AbstractServiceException {
        validateCommandName(command);
        String branchName = command.getArgs().get(0);
        if(branchManagementService.getBranch(branchName) == null) {
            throw new ResourceNotFoundException(ServiceError.BRANCH_NOT_FOUND_ERROR);
        }
    }

    @Override
    public void execute(Command command) throws ResourceNotFoundException {
        final List<String> args = command.getArgs();
        final String branchName = args.get(0);
        final String vehicleType = args.get(1);
        final String vehicleId = args.get(2);
        final int price = Integer.parseInt(args.get(3));
        Vehicle vehicle = branchManagementService.addVehicle(branchName, vehicleId, VehicleType.getVehicleType(vehicleType), price);
        Branch branch = branchManagementService.getBranch(branchName);
        slotBookingService.addNewVehicle(branch, vehicle);
    }
}
