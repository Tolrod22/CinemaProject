package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Movie;
import fr.ensibs.entities.Ticket;

import javax.ejb.Remote;
import java.util.Date;
import java.util.List;

@Remote
public interface TicketServiceRemote {

    void createTicket(Double price, Date endValidation, Integer number, Movie movie);

    List<Ticket> getAllTicketsFromMovie(Movie movie);

    void removeTicket(Long id, Long movie);

}
