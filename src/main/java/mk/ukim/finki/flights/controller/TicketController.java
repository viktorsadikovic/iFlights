package mk.ukim.finki.flights.controller;

import mk.ukim.finki.flights.enummerations.Class;
import mk.ukim.finki.flights.enummerations.LuggageType;
import mk.ukim.finki.flights.model.Flight;
import mk.ukim.finki.flights.model.Passenger;
import mk.ukim.finki.flights.model.Ticket;
import mk.ukim.finki.flights.service.AirlinesCompanyService;
import mk.ukim.finki.flights.service.LuggageService;
import mk.ukim.finki.flights.service.PassengerService;
import mk.ukim.finki.flights.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Optional;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;
    private final AirlinesCompanyService airlinesCompanyService;
    private final PassengerService passengerService;
    private final LuggageService luggageService;

    public TicketController(TicketService ticketService, AirlinesCompanyService airlinesCompanyService, PassengerService passengerService, LuggageService luggageService) {
        this.ticketService = ticketService;
        this.airlinesCompanyService = airlinesCompanyService;
        this.passengerService = passengerService;
        this.luggageService = luggageService;
    }

    @GetMapping
    public String getTicketPage(Model model) {
        model.addAttribute("bodyContent", "ticket-form");
        return "master-template";
    }

    @PostMapping("/saveTicket")
    public String saveTicket(HttpServletRequest req,
                             @RequestParam String luggage,
                             @RequestParam Integer weight,
                             @RequestParam String klasa,
                             @RequestParam Integer seat) {

        req.getSession().setAttribute("class", klasa);
        req.getSession().setAttribute("seat", seat);
        req.getSession().setAttribute("weight", weight);
        req.getSession().setAttribute("luggage", luggage);

        return "redirect:/ticket/ticketConfirmation";
    }

    @GetMapping("/ticketConfirmation")
    public String ticketConfirmationPage(Model model, HttpServletRequest req) {
        Passenger passenger = (Passenger) req.getSession().getAttribute("passenger");
        Flight flight = (Flight) req.getSession().getAttribute("flight");

        model.addAttribute("passenger", passenger);
        model.addAttribute("flight", flight);
        model.addAttribute("departureAirport", req.getSession().getAttribute("departureAirport"));
        model.addAttribute("arrivalAirport", req.getSession().getAttribute("arrivalAirport"));

        model.addAttribute("bodyContent", "ticket-details");

        return "master-template";
    }

    @PostMapping("/confirmTicket")
    @Transactional
    public String confirmTicket(HttpServletRequest req) {
        Passenger passenger = (Passenger) req.getSession().getAttribute("passenger");
        Flight flight = (Flight) req.getSession().getAttribute("flight");

        Optional<Passenger> passengerNew = passengerService.save(passenger.getPassport_number(), passenger.getFirst_name(), passenger.getLast_name(),
                passenger.getEmail(), passenger.getAddress(), passenger.getPhone_number(), passenger.getAccount_number());
        System.out.println(passengerNew.get());

        Ticket ticket = ticketService.save(Integer.parseInt(req.getSession().getAttribute("seat").toString()), flight.getPrice(),
                Class.valueOf(req.getSession().getAttribute("class").toString()), "", passengerNew.get(), flight).get();

        System.out.println("test");

        luggageService.save(LuggageType.valueOf(req.getSession().getAttribute("luggage").toString()),
                Integer.parseInt(req.getSession().getAttribute("weight").toString()), ticket);

        return "redirect:/home";
    }
}
