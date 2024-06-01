package org.example.models;

import java.util.List;

public class Slot {
    private final int hour;
    private final List<Vehicle> availableVehicles;

    public Slot(int slotHour, List<Vehicle> vehicle) {
        this.hour = slotHour;
        this.availableVehicles = vehicle;
    }

    public int getHour() {
        return hour;
    }

    public List<Vehicle> getAvailableVehicles() {
        return availableVehicles;
    }

    public void addNewVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
    }
}
