package mk.ukim.finki.flights.service.impl;

import mk.ukim.finki.flights.enummerations.Class;
import mk.ukim.finki.flights.model.Flight;
import mk.ukim.finki.flights.model.Passenger;
import mk.ukim.finki.flights.model.Ticket;
import mk.ukim.finki.flights.repository.TicketRepository;
import mk.ukim.finki.flights.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Ticket> save(Integer seat, Integer price, Class klasa, String description, Passenger passenger, Flight flight) {
        return Optional.of(ticketRepository.save(new Ticket(seat, price, klasa, description, passenger, flight)));
    }
}
