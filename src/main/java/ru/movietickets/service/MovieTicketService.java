package ru.movietickets.service;


import ru.movietickets.db.Ticket;
import ru.movietickets.repository.MovieTicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketService {

    @Autowired
    MovieTicketsRepository movieTicketsRepository;

    public Iterable<Ticket> all() {
        return movieTicketsRepository.findAll();
    }

    public Ticket create(Ticket ticket) {
        return movieTicketsRepository.save(ticket);
    }

    public Ticket find(int ticketId) {
        return movieTicketsRepository.findOne(ticketId);
    }

    public Ticket update(Ticket updatedTicket) {
        return movieTicketsRepository.save(updatedTicket);
    }

    public void delete(int ticketId) {
        movieTicketsRepository.delete(ticketId);
    }

    public Iterable<Ticket> updateAll() {
        return movieTicketsRepository.findAll();
    }

}
