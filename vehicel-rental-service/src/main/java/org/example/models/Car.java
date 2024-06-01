package org.example.models;

import org.example.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String vehicleId, int price) {
        super(vehicleId, VehicleType.CAR, price);
    }
}
