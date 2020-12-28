package mk.ukim.finki.flights.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "passenger")
public class Passenger {
    @Id
    @NotNull @NotBlank @NotEmpty
    String passport_number;

    @NotNull @NotBlank @NotEmpty
    String first_name;

    @NotNull @NotBlank @NotEmpty
    String last_name;

    @NotNull @NotBlank @NotEmpty
    String email;

    @NotNull @NotBlank @NotEmpty
    String address;

    @NotNull @NotBlank @NotEmpty
    String phone_number;

    @NotNull @NotBlank @NotEmpty
    String account_number;

    public Passenger() {

    }

    public Passenger(String passport_number, String first_name,String last_name, String email, String address, String phone_number, String account_number) {
        this.passport_number = passport_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.account_number = account_number;
    }

}
