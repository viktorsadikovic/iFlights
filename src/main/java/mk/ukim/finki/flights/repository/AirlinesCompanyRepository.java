package mk.ukim.finki.flights.repository;

import mk.ukim.finki.flights.model.AirlinesCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlinesCompanyRepository extends JpaRepository<AirlinesCompany, Integer> {
}
