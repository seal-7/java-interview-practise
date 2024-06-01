package org.example.services;

import org.example.dao.BranchDao;
import org.example.enums.VehicleType;
import org.example.models.Branch;
import org.example.models.Slot;
import org.example.models.Vehicle;
import org.example.strategy.VehicleReservationStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class SlotBookingService {

    private BranchDao branchDao;
    private final Map<Branch, List<Slot>> branchToSlotMap;
    private final VehicleReservationStrategy vehicleReservationStrategy;

    public SlotBookingService(VehicleReservationStrategy vehicleReservationStrategy) {
        this.vehicleReservationStrategy = vehicleReservationStrategy;
        this.branchToSlotMap = new HashMap<>();
        this.branchDao = BranchDao.getInstance();
    }

    public void initialiseSlots(Branch branch) {
        List<Slot> newSlots = new ArrayList<>();
        for(int i=0 ; i<24; i++) {
            Slot slot = new Slot(i, (List<Vehicle>) ((ArrayList)branch.getVehicles()).clone());
            newSlots.add(slot);
        }
        branchToSlotMap.put(branch, newSlots);
    }

    public void addNewVehicle(Branch branch, Vehicle vehicle) {
        List<Slot> slots = branchToSlotMap.get(branch);
        for(Slot slot: slots) {
            slot.addNewVehicle(vehicle);
        }
        branchToSlotMap.put(branch, slots);
    }

    public void bookVehicle(Branch branch, VehicleType vehicleType, List<Integer> hours) {
        List<Vehicle> availableVehicle = getAvailableVehicle(branch, hours);
        Vehicle preferredVehicle = vehicleReservationStrategy.getPreferredVehicle(availableVehicle);
        List<Slot> slots = branchToSlotMap.get(branch);
        for (Slot slot: slots) {
            if (hours.contains(slot.getHour())) {
                slot.getAvailableVehicles().remove(preferredVehicle);
            }
        }
    }


    public List<Vehicle> getAvailableVehicle(Branch branch, List<Integer> hours) {
        List<Slot> slots = branchToSlotMap.get(branch);
        List<Vehicle> availableVehicles = new ArrayList<>();
        List<Vehicle> allVehicles = branch.getVehicles();
        for (Vehicle vehicle: allVehicles) {
            boolean isAvailable = false;
            for(Slot slot: slots) {
                if(slot.getAvailableVehicles().contains(vehicle)) {
                    isAvailable = true;
                } else {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                availableVehicles.add(vehicle);
            }
        }

        return availableVehicles;
    }
}
