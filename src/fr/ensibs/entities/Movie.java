package fr.ensibs.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("movie")
public class Movie {

    @Id
    @GeneratedValue
    private Long idMovie;

    private String title;

    private Date startingDate;

    private Date endingDate;

    @OneToMany
    private List<Ticket> tickets;

    @ManyToMany
    @JoinTable
    private List<Cinema> cinemas;

    public Movie() {
    }

    public Long getIdMovie() { return idMovie; }

    public void setIdMovie(Long idMovie) { this.idMovie = idMovie; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Date getStartingDate() { return startingDate; }

    public void setStartingDate(Date startingDate) { this.startingDate = startingDate; }

    public Date getEndingDate() { return endingDate; }

    public void setEndingDate(Date endingDate) { this.endingDate = endingDate; }

    public List<Cinema> getCinemas() { return cinemas; }

    public void setCinemas(List<Cinema> cinemas) { this.cinemas = cinemas; }

    public List<Ticket> getTickets() { return tickets; }

    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }
}
