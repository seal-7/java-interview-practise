package org.example.services;

import org.example.dao.BranchDao;
import org.example.enums.ServiceError;
import org.example.enums.VehicleType;
import org.example.exceptions.ResourceNotFoundException;
import org.example.models.Branch;
import org.example.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BranchManagementService {

    private final BranchDao branchDao;

    public BranchManagementService() {
        this.branchDao = BranchDao.getInstance();
    }


    
    public void addBranch(String branchName) {
        final Branch branch = new Branch(branchName, new ArrayList<>());
        List<Branch> branches = branchDao.getBranches();
        branches.add(branch);
        branchDao.setBranches(branches);
    }

    
    public Vehicle addVehicle(String branchName, String vehicleId, VehicleType vehicleType, int price) throws ResourceNotFoundException {
        Branch branch = getBranch(branchName);
        Vehicle vehicle = new Vehicle(vehicleId, vehicleType, price);
        List<Vehicle> vehicles = branch.getVehicles();
        vehicles.add(vehicle);
        return vehicle;
    }
    
    
    public Branch getBranch(String branchName) {
        List<Branch> branches = branchDao.getBranches();
        Optional<Branch> first = branches.stream().filter(branch -> branchName.equals(branch.getBranchName())).findFirst();
        return first.orElse(null);
    }

    
    public List<Vehicle> getVehicles(String branchName) throws ResourceNotFoundException {
        Branch branch = getBranch(branchName);
        if (branch == null) {
            throw new ResourceNotFoundException(ServiceError.BRANCH_NOT_FOUND_ERROR);
        }
        return branch.getVehicles();
    }


}
