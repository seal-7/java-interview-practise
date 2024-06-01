package org.example.utils;

import org.example.models.Vehicle;

import java.util.List;

public class OutputPrinter {

    public static void printVehicles(List<Vehicle> vehicleList) {
        for (Vehicle vehicle: vehicleList) {
            System.out.printf("VehicleId: %s, VehicleType: %s%n", vehicle.getVehicleId(), vehicle.getVehicleType());
        }
    }
}
