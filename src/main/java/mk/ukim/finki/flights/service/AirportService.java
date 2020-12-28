package mk.ukim.finki.flights.service;

import mk.ukim.finki.flights.model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<Airport> findAll();
    Optional<Airport> findById(Integer id);
}
