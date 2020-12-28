package mk.ukim.finki.flights.repository;

import mk.ukim.finki.flights.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsCountRepository extends JpaRepository<Statistics, Integer> {
}
