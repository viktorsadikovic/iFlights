package mk.ukim.finki.flights.service.impl;

import mk.ukim.finki.flights.model.AirlinesCompany;
import mk.ukim.finki.flights.model.Airport;
import mk.ukim.finki.flights.model.Flight;
import mk.ukim.finki.flights.repository.AirlinesCompanyRepository;
import mk.ukim.finki.flights.repository.FlightRepository;
import mk.ukim.finki.flights.service.AirportService;
import mk.ukim.finki.flights.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final AirportService airportService;
    private final AirlinesCompanyRepository airlinesCompanyRepository;

    public FlightServiceImpl(FlightRepository flightRepository, AirportService airportService, AirlinesCompanyRepository airlinesCompanyRepository) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
        this.airlinesCompanyRepository = airlinesCompanyRepository;
    }

    @Override
    public List<Flight> findAll() {
        return null;
    }

    @Override
    public Optional<Flight> findById(String id) {
        return flightRepository.findById(id);
    }

    @Override
    public Optional<Flight> save(String flight_number, String gate, Airport airport_departure, LocalDateTime time_departure, Airport airport_arrival, LocalDateTime time_arrival, AirlinesCompany company, Integer price) {
        return Optional.of(flightRepository.save(new Flight(flight_number, gate, airport_departure, time_departure, airport_arrival, time_arrival,
                company, price)));
    }

    @Override
    public Optional<Flight> edit(String flight_number, String gate, Airport airport_departure, LocalDateTime time_departure, Airport airport_arrival, LocalDateTime time_arrival, AirlinesCompany company, Integer price) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String flight_number) {

    }

    @Override
    public List<Flight> findAllByAirportArrivalAndAirportDeparture(Integer arrival, Integer departure) {
        return this.flightRepository.findAllByAirportArrivalAndAirportDeparture(this.airportService.findById(arrival).get(), this.airportService.findById(departure).get());
    }

    @Override
    public List<Flight> findAllByCompany(Integer id) {
        return flightRepository.findAllByCompany(airlinesCompanyRepository.findById(id).get());
    }
}
