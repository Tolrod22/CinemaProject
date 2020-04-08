package fr.ensibs.sessions;

import fr.ensibs.entities.Cinema;
import fr.ensibs.entities.Employee;
import fr.ensibs.entities.Movie;
import fr.ensibs.entities.Ticket;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
public class TicketService implements TicketServiceLocal, TicketServiceRemote {

    @PersistenceContext(unitName = "cinema")
    private EntityManager em;

    @Override
    public void createTicket(Double price, Date endValidation, Integer number, Movie movie) {
        for (int i=0; i<number; i++){
            Ticket ticket = new Ticket();
            ticket.setPrice(price);
            ticket.setEndValidation(endValidation);
            ticket.setMovie(movie);
            em.persist(ticket);
        }
        em.getEntityManagerFactory().getCache().evict(Movie.class, movie.getIdMovie());
    }

    @Override
    public List<Ticket> getAllTicketsFromMovie(Movie movie) {
        return em.createQuery("SELECT t FROM Ticket t WHERE t.movie = :movieid", Ticket.class).setParameter("movieid", movie).getResultList();
    }

    @Override
    public void removeTicket(Long id, Long movie) {
        Ticket toRemove = em.createQuery("SELECT t FROM Ticket t WHERE t.idTicket = :ticketId", Ticket.class).setParameter("ticketId", id).getSingleResult();
        em.remove(toRemove);
        em.getEntityManagerFactory().getCache().evict(Movie.class, movie);
    }
}
