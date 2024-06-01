package org.example.strategy;

import org.example.models.Vehicle;

import java.util.Comparator;
import java.util.List;

public class LowestPriceReservationStrategy implements VehicleReservationStrategy {
    @Override
    public Vehicle getPreferredVehicle(List<Vehicle> vehicles) {
        return vehicles.stream().min(Comparator.comparingInt(Vehicle::getPrice)).get();
    }
}
