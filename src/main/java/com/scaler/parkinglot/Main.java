package com.scaler.parkinglot;

import com.scaler.parkinglot.controllers.TicketController;
import com.scaler.parkinglot.dtos.CreateTicketRequestDto;
import com.scaler.parkinglot.dtos.CreateTicketResponseDto;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import com.scaler.parkinglot.repositories.ParkingSpotRepository;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.services.TicketService;
import com.scaler.parkinglot.strategies.spotassignment.RandomSpotAssignmentStrategy;
import com.scaler.parkinglot.strategies.spotassignment.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {
        ObjectRegistry objectRegistry = new ObjectRegistry();
        objectRegistry.register(
                "parkingLotRepository",
                new ParkingLotRepository()
        );
        objectRegistry.register(
                "parkingSpotRepository",
                new ParkingSpotRepository()
        );
        objectRegistry.register(
                "ticketRepository",
                new TicketRepository()
        );
        objectRegistry.register(
                "spotAssignmentStrategy",
                new RandomSpotAssignmentStrategy()
        );
        objectRegistry.register(
                "ticketService",
                new TicketService(
                        (TicketRepository) objectRegistry.get("ticketRepository"),
                        (SpotAssignmentStrategy) objectRegistry.get("spotAssignmentStrategy"),
                        (ParkingLotRepository) objectRegistry.get("parkingLotRepository"),
                        (ParkingSpotRepository) objectRegistry.get("parkingSpotRepository")
                )
        );
        objectRegistry.register(
                "ticketController",
                new TicketController(
                        (TicketService) objectRegistry.get("ticketService")
                )
        );


        CreateTicketRequestDto request = new CreateTicketRequestDto();
        request.setGate(null);
        request.setVehicle(null);

        CreateTicketResponseDto response = ((TicketController) objectRegistry.get(
                "ticketController"
        )).createTicket(request);

        System.out.println("Hello world!");
    }
}