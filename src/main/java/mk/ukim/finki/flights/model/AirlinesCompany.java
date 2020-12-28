package mk.ukim.finki.flights.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "airlines_company")
public class AirlinesCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_company;

    @NotNull @NotEmpty @NotBlank
    String name;

    @NotNull @NotEmpty @NotBlank
    String city;

    @NotNull @NotEmpty @NotBlank
    String country;

    @ManyToMany
    @JoinTable(name = "has_office",
            joinColumns = @JoinColumn(name = "id_company"),
            inverseJoinColumns = @JoinColumn(name = "id_airport"))
    List<Airport> airports;

    public AirlinesCompany() {

    }

    public AirlinesCompany(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }


}
