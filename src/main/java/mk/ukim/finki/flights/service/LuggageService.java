package mk.ukim.finki.flights.service;

import mk.ukim.finki.flights.enummerations.LuggageType;
import mk.ukim.finki.flights.model.Luggage;
import mk.ukim.finki.flights.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface LuggageService {

    Optional<Luggage> save(LuggageType type, Integer weight, Ticket ticket);
    List<Luggage> findAllByTicketNumber(Integer ticket_number);
}
