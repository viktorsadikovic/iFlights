package mk.ukim.finki.flights.controller;

import mk.ukim.finki.flights.model.Statistics;
import mk.ukim.finki.flights.repository.FlightsCountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportsController {

    private final FlightsCountRepository flightsCountRepository;

    public ReportsController(FlightsCountRepository flightsCountRepository) {
        this.flightsCountRepository = flightsCountRepository;
    }


    @GetMapping
    public String getReportsPage(Model model) {
        List<Statistics> stats = flightsCountRepository.findAll();
        model.addAttribute("bodyContent","reports");
        model.addAttribute("stats", stats);

        return "master-template";
    }
}
