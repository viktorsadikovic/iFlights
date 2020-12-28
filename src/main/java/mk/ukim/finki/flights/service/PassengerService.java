package mk.ukim.finki.flights.service;

import mk.ukim.finki.flights.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Optional<Passenger> save(String passport_number, String first_name,String last_name, String email, String address,
                             String phone_number, String account_number);

    List<Passenger> findAll();

//    List<Passenger> findAllByFlightNumber(String flight_number);
}
