package mk.ukim.finki.flights.service;

import mk.ukim.finki.flights.model.AirlinesCompany;
import mk.ukim.finki.flights.model.Airport;
import mk.ukim.finki.flights.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> findAll();

    Optional<Flight> findById(String id);

    Optional<Flight> save(String flight_number, String gate, Airport airport_departure, LocalDateTime time_departure,
                          Airport airport_arrival, LocalDateTime time_arrival, AirlinesCompany company, Integer price);

    Optional<Flight> edit(String flight_number, String gate, Airport airport_departure, LocalDateTime time_departure,
                          Airport airport_arrival, LocalDateTime time_arrival, AirlinesCompany company, Integer price);

    void deleteById(String flight_number);

    List<Flight> findAllByAirportArrivalAndAirportDeparture(Integer arrival, Integer departure);

    List<Flight> findAllByCompany(Integer id);
}
