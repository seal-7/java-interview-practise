package org.example.models;

import java.util.List;

public class Branch {
    private final String branchName;
    private final List<Vehicle> vehicles;

    public Branch(String branchName, List<Vehicle> vehicles) {
        this.branchName = branchName;
        this.vehicles = vehicles;
    }

    public String getBranchName() {
        return branchName;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
