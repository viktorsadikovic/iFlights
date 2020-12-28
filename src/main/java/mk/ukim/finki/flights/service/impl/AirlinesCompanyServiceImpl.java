package mk.ukim.finki.flights.service.impl;

import mk.ukim.finki.flights.model.AirlinesCompany;
import mk.ukim.finki.flights.repository.AirlinesCompanyRepository;
import mk.ukim.finki.flights.service.AirlinesCompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlinesCompanyServiceImpl implements AirlinesCompanyService {
    private final AirlinesCompanyRepository airlinesCompanyRepository;

    public AirlinesCompanyServiceImpl(AirlinesCompanyRepository airlinesCompanyRepository) {
        this.airlinesCompanyRepository = airlinesCompanyRepository;
    }

    @Override
    public List<AirlinesCompany> findAll() {
        return this.airlinesCompanyRepository.findAll();
    }

    @Override
    public Optional<AirlinesCompany> findById(Integer id) {
        return airlinesCompanyRepository.findById(id);
    }
}
