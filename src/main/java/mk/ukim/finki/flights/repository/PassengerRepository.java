package mk.ukim.finki.flights.repository;

import mk.ukim.finki.flights.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String> {

}
