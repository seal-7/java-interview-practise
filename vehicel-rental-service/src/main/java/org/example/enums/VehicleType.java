package org.example.enums;

import java.util.Arrays;
import java.util.Optional;

public enum VehicleType {
    CAR("Car"),
    BIKE("Bike");

    VehicleType(String value) {
        this.value = value;
    }

    private final String value;

    public static VehicleType getVehicleType(String vehicleType) {
        Optional<VehicleType> first = Arrays.stream(VehicleType.values()).filter(vehicleType1 -> vehicleType1.getValue().equals(vehicleType)).findFirst();
        return first.orElse(null);
    }

    public String getValue() {
        return value;
    }
}
