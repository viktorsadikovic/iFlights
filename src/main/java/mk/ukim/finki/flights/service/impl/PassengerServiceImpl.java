package mk.ukim.finki.flights.service.impl;

import mk.ukim.finki.flights.model.Passenger;
import mk.ukim.finki.flights.repository.PassengerRepository;
import mk.ukim.finki.flights.service.PassengerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Optional<Passenger> save(String passport_number, String first_name, String last_name, String email, String address, String phone_number, String account_number) {
        return Optional.of(passengerRepository.save(new Passenger(passport_number, first_name, last_name, email, address, phone_number, account_number)));
    }

    @Override
    public List<Passenger> findAll() {
        return this.passengerRepository.findAll();
    }
}
