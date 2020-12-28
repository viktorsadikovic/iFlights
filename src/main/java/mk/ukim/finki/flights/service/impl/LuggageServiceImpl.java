package mk.ukim.finki.flights.service.impl;

import mk.ukim.finki.flights.enummerations.LuggageType;
import mk.ukim.finki.flights.model.Luggage;
import mk.ukim.finki.flights.model.Ticket;
import mk.ukim.finki.flights.repository.LuggageRepository;
import mk.ukim.finki.flights.service.LuggageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LuggageServiceImpl implements LuggageService {
    private final LuggageRepository luggageRepository;

    public LuggageServiceImpl(LuggageRepository luggageRepository) {
        this.luggageRepository = luggageRepository;
    }

    @Override
    public Optional<Luggage> save(LuggageType type, Integer weight, Ticket ticket) {
        return Optional.of(luggageRepository.save(new Luggage(type, weight, ticket)));
    }

    @Override
    public List<Luggage> findAllByTicketNumber(Integer ticket_number) {
        return null;
    }
}
