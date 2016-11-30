package ru.movietickets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.movietickets.db.Ticket;
import ru.movietickets.service.MovieService;
import ru.movietickets.service.MovieTicketService;
import ru.movietickets.service.TicketValidator;

import javax.validation.Valid;


@Controller
public class AppController {

    @Autowired
    private MovieTicketService movieTicketService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TicketValidator ticketValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(ticketValidator);
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getListTicket(Model model) {
        model.addAttribute("tickets", movieTicketService.all());
        return "listticket";

    }
    @RequestMapping(value="/updateticket", method = RequestMethod.GET)
    public String updateListTicket() {
       return  "redirect:/";

    }

    @RequestMapping(value="/ticket/del/{ticketId}", method = RequestMethod.POST)
    public String ticketDelete(@PathVariable("ticketId") Integer ticketId) {
        movieTicketService.delete(ticketId);
        return "redirect:/";
    }

    @RequestMapping(value = "/ticket/edit/{ticketId}", method = RequestMethod.GET)
    public String ticketEdit(@PathVariable("ticketId") Integer ticketId, Model model) {
        model.addAttribute("ticket", movieTicketService.find(ticketId));
        model.addAttribute("movies", movieService.all() );
        return "edit";
    }

    @RequestMapping(value = "/ticket/edit/{ticketId}", method = RequestMethod.POST)
    public String ticketUpdate(@PathVariable("ticketId") Integer ticketId, Model model, @Valid  Ticket ticket, BindingResult result ) {
        ticket.setId(ticketId);
        if (result.hasErrors()) {
            model.addAttribute("movies", movieService.all() );
            return "edit";
        }
        movieTicketService.update(ticket);
        return "redirect:/";

    }

    @RequestMapping(value="/newticket", method = RequestMethod.GET)
    public String newTicket(Model model ) {
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("movies", movieService.all() );
        return "new";
    }


    @RequestMapping(value="/newticket", method = RequestMethod.POST)
    public String createTicket(Model model, @Valid Ticket ticket, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("movies", movieService.all() );
            return "new";
        }
            movieTicketService.create(ticket);
            return "redirect:/";


    }



}
