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
    private List<Cinema> cinemas;

    public Movie() {
    }

    @Column(name = "movie_id")
    public Long getIdMovie() { return idMovie; }

    public void setIdMovie(Long idMovie) { this.idMovie = idMovie; }

    @Column(name = "movie_title")
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    @Column(name = "movie_startingDate")
    public Date getStartingDate() { return startingDate; }

    public void setStartingDate(Date startingDate) { this.startingDate = startingDate; }

    @Column(name = "movie_endingDate")
    public Date getEndingDate() { return endingDate; }

    public void setEndingDate(Date endingDate) { this.endingDate = endingDate; }

    @Column(name = "movie_cinemas")
    public List<Cinema> getCinemas() { return cinemas; }

    public void setCinemas(List<Cinema> cinemas) { this.cinemas = cinemas; }

    @Column(name = "movie_tickets")
    public List<Ticket> getTickets() { return tickets; }

    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }
}
