package mk.ukim.finki.flights.model;

import lombok.Data;
import mk.ukim.finki.flights.enummerations.LuggageType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "luggage")
public class Luggage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private LuggageType type;

    private Integer weight;

    @JoinColumn(name = "ticket_number")
    @ManyToOne
    private Ticket ticket;

    public Luggage() {
    }

    public Luggage( LuggageType type, Integer weight, Ticket ticket) {
        this.type = type;
        this.weight = weight;
        this.ticket = ticket;
    }
}
