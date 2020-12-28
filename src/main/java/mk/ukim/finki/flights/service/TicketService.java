package mk.ukim.finki.flights.service;

import mk.ukim.finki.flights.enummerations.Class;
import mk.ukim.finki.flights.model.Flight;
import mk.ukim.finki.flights.model.Passenger;
import mk.ukim.finki.flights.model.Ticket;

import java.util.Optional;

public interface TicketService {
    Optional<Ticket> save(Integer seat, Integer price, Class klasa, String description,
                          Passenger passenger, Flight flight);


}
