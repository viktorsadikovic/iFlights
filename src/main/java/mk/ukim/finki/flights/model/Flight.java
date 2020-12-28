package mk.ukim.finki.flights.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "flight")
public class Flight {

    @Id
    String flightNumber;

    String gate;

    @ManyToOne
    @JoinColumn(name = "id_airport_departure")
    Airport airportDeparture;

    LocalDateTime time_departure;

    @ManyToOne
    @JoinColumn(name = "id_airport_arrival")
    Airport airportArrival;

    LocalDateTime time_arrival;

    @ManyToOne
    @JoinColumn(name = "id_company")
    AirlinesCompany company;

    Integer price;

    public Flight() {

    }

    public Flight(String flight_number, String gate, Airport airport_departure, LocalDateTime time_departure,
                  Airport airport_arrival, LocalDateTime time_arrival, AirlinesCompany company, Integer price) {
        this.flightNumber = flight_number;
        this.gate = gate;
        this.airportDeparture = airport_departure;
        this.time_departure = time_departure;
        this.airportArrival = airport_arrival;
        this.time_arrival = time_arrival;
        this.company = company;
        this.price = price;
    }


}
