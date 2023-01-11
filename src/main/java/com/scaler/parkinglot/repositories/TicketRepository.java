package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketRepository {
//    private List<Ticket> tickets = new ArrayList<>();
    private long lastIdCount = 0;
    private Map<Long, Ticket> tickets = new HashMap<>();

    public Ticket save(Ticket ticket) {
        lastIdCount += 1;
        ticket.setId(lastIdCount);
        tickets.put(lastIdCount, ticket);
        return ticket;
    }

//    public Ticket getTicketById(Long id) {
//        for (Ticket ticket: tickets) {
//            if (ticket.getId().equals(id)) {
//                return ticket;
//            }
//        }
//
//        return null;
//    }
}
