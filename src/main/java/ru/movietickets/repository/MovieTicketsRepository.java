package ru.movietickets.repository;


import ru.movietickets.db.Ticket;
import org.springframework.data.repository.CrudRepository;


public interface MovieTicketsRepository extends CrudRepository<Ticket, Integer> {


}
