package fr.ensibs.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@DiscriminatorValue("ticket")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    private Long idTicket;

    private double price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endValidation;

    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    public Ticket() {
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEndValidation() {
        return endValidation;
    }

    public void setEndValidation(Date endValidation) {
        this.endValidation = endValidation;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
