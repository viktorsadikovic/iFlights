package mk.ukim.finki.flights.controller;

import mk.ukim.finki.flights.model.Airport;
import mk.ukim.finki.flights.model.Flight;
import mk.ukim.finki.flights.service.AirlinesCompanyService;
import mk.ukim.finki.flights.service.AirportService;
import mk.ukim.finki.flights.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/flight")
public class FlightController {

    private final AirportService airportService;
    private final AirlinesCompanyService airlinesCompanyService;
    private final FlightService flightService;

    public FlightController(AirportService airportService, AirlinesCompanyService airlinesCompanyService, FlightService flightService) {
        this.airportService = airportService;
        this.airlinesCompanyService = airlinesCompanyService;
        this.flightService = flightService;
    }

    @GetMapping
    public String getFlightPage(Model model) {
        model.addAttribute("bodyContent", "choose-destination");
        model.addAttribute("departureAirports", airportService.findAll());
        model.addAttribute("arrivalAirports", airportService.findAll());

        return "master-template";
    }

    @PostMapping("/selectedDestination")
    public String saveDestination(HttpServletRequest req,
                                  @RequestParam Integer departure,
                                  @RequestParam Integer arrival) {
        Airport airportDeparture = airportService.findById(departure).get();
        Airport airportArrival = airportService.findById(arrival).get();

        req.getSession().setAttribute("departureAirport", airportDeparture.getName());
        req.getSession().setAttribute("arrivalAirport", airportArrival.getName());

        req.getSession().setAttribute("departureID", departure);
        req.getSession().setAttribute("arrivalID", arrival);

        return "redirect:/flight/flights-list";
    }

    @GetMapping("/flightsByCompany")
    public String getFlightsByCompanyPage(Model model) {
        model.addAttribute("companies", airlinesCompanyService.findAll());
        model.addAttribute("bodyContent", "flights-by-company");

        return "master-template";
    }

    @PostMapping("/selectedCompany")
    public String saveSelectedCompany(HttpServletRequest req,
                                      @RequestParam Integer company){

        req.getSession().setAttribute("flightsByCompany", this.flightService.findAllByCompany(company));

        return "redirect:/flight/flightsByCompany";
    }


    @GetMapping("/flights-list")
    public String getFlightsList(Model model, HttpServletRequest req) {
        Integer departureID = Integer.parseInt(req.getSession().getAttribute("departureID").toString());
        Integer arrivalID = Integer.parseInt(req.getSession().getAttribute("arrivalID").toString());

        List<Flight> allFlights = this.flightService.findAllByAirportArrivalAndAirportDeparture(arrivalID, departureID);
        model.addAttribute("flights", allFlights);
        model.addAttribute("bodyContent", "flights-list");

        return "master-template";
    }

    @GetMapping("/new-flight")
    public String getNewFlightPage(Model model) {
        model.addAttribute("airports", this.airportService.findAll());
        model.addAttribute("companies", this.airlinesCompanyService.findAll());
        model.addAttribute("bodyContent", "add-new-flight");

        return "master-template";
    }

    @PostMapping("/saveFlight")
    public String saveFlight(@RequestParam Integer airportDeparture,
                             @RequestParam Integer airportArrival,
                             @RequestParam String timeDeparture,
                             @RequestParam String timeArrival,
                             @RequestParam Integer airlinesCompany,
                             @RequestParam String flightNumber,
                             @RequestParam String gate,
                             @RequestParam Integer price) {

        this.flightService.save(flightNumber, gate, this.airportService.findById(airportDeparture).get(), LocalDateTime.parse(timeDeparture),
                this.airportService.findById(airportArrival).get(), LocalDateTime.parse(timeArrival),
                airlinesCompanyService.findById(airlinesCompany).get(), price);

        return "redirect:/home";
    }

}
