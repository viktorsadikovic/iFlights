package mk.ukim.finki.flights.model;

import lombok.Data;
import mk.ukim.finki.flights.enummerations.Class;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticket_number;

    private Integer seat;

    private Integer price;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "class")
    private Class klasa;

    private String description;

    @JoinColumn(name = "passport_number")
    @ManyToOne
    private Passenger passenger;

    @JoinColumn(name = "flight_number")
    @ManyToOne
    private Flight flight;

    public Ticket() {

    }

    public Ticket(Integer seat, Integer price, Class klasa, String description,
                  Passenger passenger, Flight flight) {
        this.seat = seat;
        this.price = price;
        this.klasa = klasa;
        this.description = description;
        this.passenger = passenger;
        this.flight = flight;
    }
}
