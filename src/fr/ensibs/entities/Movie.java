package fr.ensibs.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue
    private Long idMovie;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startingDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endingDate;

    @OneToMany(
            mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Ticket> tickets = new ArrayList<>();;

    @ManyToMany
    @JoinTable
    private List<Cinema> cinemas = new ArrayList<>();
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

    public void addCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
