package ru.movietickets.service;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.movietickets.db.Ticket;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TicketValidator implements Validator {

    public static boolean regTel(String regTel){
        Pattern p = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher m = p.matcher(regTel);
        return m.matches();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Ticket.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Ticket ticket = (Ticket) o;

        /*Movie*/
   if(ticket.getMovieTicket().getMovieId() == null) {
            errors.rejectValue("movieTicket.movieId", "ticket.empty");    }
        /*Name*/
     if(ticket.getName().isEmpty()) {
            errors.rejectValue("name", "ticket.empty");
     }else if (ticket.getName().length() < 4) {
            errors.rejectValue("name", "ticket.short");
     }else if (ticket.getName().length() > 30) {
         errors.rejectValue("name", "ticket.long");
     }

        /*Tel*/
    if(ticket.getTel().isEmpty()) {
        errors.rejectValue("tel", "ticket.empty");
    }else if ((!regTel(ticket.getTel()))) {
        errors.rejectValue("tel", "ticket.notinst");
    }

        /* Hall */
    if((ticket.getHall()  == null)) {
           errors.rejectValue("hall", "ticket.empty");
    }else if (ticket.getHall() < 1) {
            errors.rejectValue("hall", "ticket.negative");
    } else if(ticket.getHall() > 6) {
        errors.rejectValue("hall", "ticket.big");
    }

        /* Row */
    if((ticket.getRow()  == null)) {
            errors.rejectValue("row", "ticket.empty");
    }else if (ticket.getRow() < 1) {
            errors.rejectValue("row", "ticket.negative");
    }else if(ticket.getRow()> 20) {
            errors.rejectValue("row", "ticket.big");
    }

       /* Space*/
     if((ticket.getSpace() == null)) {
            errors.rejectValue("space", "ticket.empty");
      }else if (ticket.getSpace() < 1) {
            errors.rejectValue("space", "ticket.negative");
      }else if(ticket.getSpace() > 20) {
            errors.rejectValue("space", "ticket.big");
      }

        }

}
