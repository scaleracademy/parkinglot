package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.Ticket;

public class CreateTicketResponseDto {
    private Ticket ticket;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
