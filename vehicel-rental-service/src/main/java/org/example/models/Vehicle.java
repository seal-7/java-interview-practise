package org.example.models;

import org.example.enums.VehicleType;

public class Vehicle {
    private final String vehicleId;
    private final VehicleType vehicleType;

    private final int price;

    public Vehicle(String vehicleId, VehicleType vehicleType, int price) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.price = price;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getPrice() {
        return price;
    }
}
