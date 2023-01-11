package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.ParkingFloor;
import com.scaler.parkinglot.models.ParkingSpot;

import java.util.List;

public class AddParkingFloorRequestDto {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private List<ParkingSpot> parkingSpots;

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }


}
