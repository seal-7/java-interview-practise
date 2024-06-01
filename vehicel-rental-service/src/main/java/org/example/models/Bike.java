package org.example.models;

import org.example.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String vehicleId, int price) {
        super(vehicleId, VehicleType.BIKE, price);
    }
}
