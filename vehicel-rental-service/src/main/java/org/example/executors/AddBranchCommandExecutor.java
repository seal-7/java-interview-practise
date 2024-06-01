package org.example.executors;

import org.example.constants.CommandConstants;
import org.example.enums.ServiceError;
import org.example.exceptions.InvalidCommandException;
import org.example.exceptions.ResourceAlreadyExistsException;
import org.example.models.Branch;
import org.example.models.Command;
import org.example.services.BranchManagementService;
import org.example.services.SlotBookingService;

import java.util.List;

public class AddBranchCommandExecutor extends AbstractCommandExecutor {

    final BranchManagementService branchManagementService;
    final SlotBookingService slotBookingService;

    public AddBranchCommandExecutor(BranchManagementService branchManagementService,
                                    SlotBookingService slotBookingService) {
        super(CommandConstants.ADD_BRANCH_COMMAND_NAME);
        this.branchManagementService = branchManagementService;
        this.slotBookingService = slotBookingService;
    }

    @Override
    public void validate(Command command) throws InvalidCommandException, ResourceAlreadyExistsException {
        validateCommandName(command);
        String branchName = command.getArgs().get(0);
        if(branchManagementService.getBranch(branchName) != null) {
            throw new ResourceAlreadyExistsException(ServiceError.DUPLICATE_BRANCH_ERROR);
        }
    }

    @Override
    public void execute(Command command) {
        List<String> args = command.getArgs();
        String branchName = args.get(0);
        branchManagementService.addBranch(branchName);
        final Branch branch = branchManagementService.getBranch(branchName);
        slotBookingService.initialiseSlots(branch);
    }
}
