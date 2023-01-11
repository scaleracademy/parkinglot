package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.CreateTicketRequestDto;
import com.scaler.parkinglot.dtos.CreateTicketResponseDto;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public CreateTicketResponseDto createTicket(CreateTicketRequestDto request) {
        Ticket ticket = ticketService.createTicket(
                request.getVehicle(),
                request.getGate()
        );

        CreateTicketResponseDto response = new CreateTicketResponseDto();
        response.setTicket(ticket);

        return response;
    }
}
