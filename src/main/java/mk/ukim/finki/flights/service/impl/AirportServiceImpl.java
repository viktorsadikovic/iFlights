package mk.ukim.finki.flights.service.impl;

import mk.ukim.finki.flights.model.Airport;
import mk.ukim.finki.flights.repository.AirportRepository;
import mk.ukim.finki.flights.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> findById(Integer id) {
        return airportRepository.findById(id);
    }
}
