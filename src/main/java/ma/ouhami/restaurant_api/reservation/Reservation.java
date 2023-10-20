package ma.ouhami.restaurant_api.reservation;

import java.time.LocalDate;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import ma.ouhami.restaurant_api.customer.Customer;
import ma.ouhami.restaurant_api.restaurant.Restaurant;

@Entity
@Data
public class Reservation {
    
    @EmbeddedId
    private ReservationCP id;

    @ManyToOne
    @MapsId("customer")
    private Customer customer;

    @ManyToOne
    @MapsId("restaurant")
    private Restaurant restaurant;

    private LocalDate date_res;

    public Reservation(){

    }
    public Reservation(Customer customer, Restaurant restaurant){
        this.customer = customer;
        this.restaurant = restaurant;
        this.id = new ReservationCP(restaurant, customer);
    }


}
