package mk.ukim.finki.flights.service;

import mk.ukim.finki.flights.model.AirlinesCompany;

import java.util.List;
import java.util.Optional;

public interface AirlinesCompanyService {
    List<AirlinesCompany> findAll();
    Optional<AirlinesCompany> findById(Integer id);
}
