package mk.ukim.finki.flights.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "airport")
public class Airport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_airport;

    @NotNull @NotBlank @NotEmpty
    String name;

    @NotNull @NotBlank @NotEmpty
    String city;

    @NotNull @NotBlank @NotEmpty
    String country;

    @ManyToMany(mappedBy = "airports")
    List<AirlinesCompany> companies;

    public Airport() {

    }

    public Airport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

}
