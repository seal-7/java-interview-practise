package org.example.strategy;

import org.example.models.Vehicle;

import java.util.List;

public interface VehicleReservationStrategy {
    public Vehicle getPreferredVehicle(List<Vehicle> vehicles);
}
