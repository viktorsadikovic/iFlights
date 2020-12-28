package mk.ukim.finki.flights.repository;

import mk.ukim.finki.flights.model.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuggageRepository extends JpaRepository<Luggage, Integer> {
}
