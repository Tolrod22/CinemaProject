package fr.ensibs.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("ticket")
public class Ticket {

    @Id
    @GeneratedValue
    private Long idTicket;

    private double price;

    private Date endValidation;

    public Ticket() {
    }

    @Column(name = "ticket_id")
    public Long getIdTicket() { return idTicket; }

    public void setIdTicket(Long idTicket) { this.idTicket = idTicket; }

    @Column(name = "ticket_price")
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Column(name = "ticket_endValidation")
    public Date getEndValidation() { return endValidation; }

    public void setEndValidation(Date endValidation) { this.endValidation = endValidation; }
}
