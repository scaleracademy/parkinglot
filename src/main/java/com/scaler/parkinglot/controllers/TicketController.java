package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.dto.ResponseStatus;
import com.scaler.parkinglot.exceptions.NoParkingSpotAvailableException;
import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.models.Operator;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) {
        // 1. Get vehicle
        // 2. Generate ticket

        // TicketService - generateTicket()
        //     VehicleService - getVehicleByNumber()
        //     VehiclerService - createVehicle()
        //     assignSpot()
        //     createTicketObjectAndStore()

        try {
            Ticket ticket = ticketService.generateTicket(
                    request.getVehicleNumber(), request.getVehicleType(), request.getGateId()
            );

            GenerateTicketResponseDto response = new GenerateTicketResponseDto();
            response.setTicket(ticket);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            return response;
        } catch (NoParkingSpotAvailableException noParkingSpotAvailableException) {
            GenerateTicketResponseDto response = new GenerateTicketResponseDto();
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }
    }
}

// /ticket
// POST /ticket
// {
//   spot:
// }
// GET /ticket?id={}

// Problems with directly involving models:
// 1. If we need more params, current clients will start failing
// 2. Models are internal implementation details of my system and I may not want to give them to client
// 3. Client will have to do a lot of GET just to be able to make the request
//    (Eg: If client doesn't know about vehicle, they will first need to GET and then make the request)

// dto - Data Transfer Objects
//     - Params and return types of controller methods