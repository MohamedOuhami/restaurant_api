package ma.ouhami.restaurant_api.reservation;

import jakarta.persistence.Embeddable;
import ma.ouhami.restaurant_api.customer.Customer;
import ma.ouhami.restaurant_api.restaurant.Restaurant;

@Embeddable
public class ReservationCP {
    
    private Integer restaurant_id;
    private Integer customer_id;

    public ReservationCP(){

    }
    
    public ReservationCP(Restaurant restaurant, Customer customer){
        this.restaurant_id = restaurant.getId();
        this.customer_id = customer.getId();
    }

    
}
