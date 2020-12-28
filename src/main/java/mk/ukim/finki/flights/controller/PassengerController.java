package mk.ukim.finki.flights.controller;

import mk.ukim.finki.flights.model.Passenger;
import mk.ukim.finki.flights.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
    private final FlightService flightService;

    public PassengerController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/newPassenger/{number}")
    public String getPassengerPage(Model model, @PathVariable String number, HttpServletRequest req) {
        req.getSession().setAttribute("flight", flightService.findById(number).get());
        model.addAttribute("bodyContent", "passenger-form");

        return "master-template";
    }

    @PostMapping("/savePassenger")
    public String savePassenger(HttpServletRequest req,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String address,
                                @RequestParam String email,
                                @RequestParam String passportNumber,
                                @RequestParam String phoneNumber,
                                @RequestParam String accountNumber) {

        req.getSession().setAttribute("passenger", new Passenger(passportNumber, firstName, lastName, email, address, phoneNumber, accountNumber));

        return "redirect:/ticket";
    }
}
