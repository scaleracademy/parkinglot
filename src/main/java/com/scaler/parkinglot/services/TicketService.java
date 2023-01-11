package com.scaler.parkinglot.services;

import com.scaler.parkinglot.exceptions.NoAvailableParkingSpotException;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.ParkingSpotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.strategies.spotassignment.RandomSpotAssignmentStrategy;
import com.scaler.parkinglot.strategies.spotassignment.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(TicketRepository ticketRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository,
                         ParkingSpotRepository parkingSpotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket createTicket(Vehicle vehicle, Gate gate) throws NoAvailableParkingSpotException {
//        private Date entryTime;
//        private Operator operator;
//        private Gate gate;
//        private Vehicle vehicle;
//        private ParkingSpot parkingSpot;

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLotRepository.getParkingLotForGate(gate)
                ,vehicle.getVehicleType());
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingSpotRepository.save(parkingSpot);

        ticket.setParkingSpot(
                parkingSpot
        );



        return ticketRepository.save(ticket);
    }
}


// BREAK TILL 10:17 PM