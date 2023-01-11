package com.scaler.parkinglot.strategies.spotassignment;

import com.scaler.parkinglot.models.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor parkingFloor: parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpots()) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
                parkingSpot.getSupportedVehicleTypes().contains(vehicleType)) {
                    return parkingSpot;
                }
            }
        }

        return null;
    }
}
