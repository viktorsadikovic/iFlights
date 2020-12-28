package mk.ukim.finki.flights.repository;

import mk.ukim.finki.flights.model.AirlinesCompany;
import mk.ukim.finki.flights.model.Airport;
import mk.ukim.finki.flights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findAllByAirportArrivalAndAirportDeparture(Airport arrival, Airport departure);

    List<Flight> findAllByCompany(AirlinesCompany company);

    Integer countAllByFlightNumber(String flightNumber);

}
