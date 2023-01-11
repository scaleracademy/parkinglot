package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.Ticket;

public class CreateTicketResponseDto {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
