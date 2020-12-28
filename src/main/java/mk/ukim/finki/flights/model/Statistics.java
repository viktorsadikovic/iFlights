package mk.ukim.finki.flights.model;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Immutable
@Table(name = "flights_statistics")
public class Statistics implements Serializable {

    @Column(name = "company_name")
    @Id
    String companyName;

    @Column(name = "num_flights")
    Integer numberFlights;

    @Column(name = "num_tickets")
    Integer numberTickets;

    @Column(name = "total_amount")
    Integer totalAmount;

    public Statistics() {

    }

}
