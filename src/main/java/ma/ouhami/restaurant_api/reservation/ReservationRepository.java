package ma.ouhami.restaurant_api.reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ouhami.restaurant_api.customer.Customer;
import ma.ouhami.restaurant_api.restaurant.Restaurant;

public interface ReservationRepository extends JpaRepository<Reservation,ReservationCP>{
    
    public List<Reservation> findByCustomer(Customer customer);
    public List<Reservation> findByRestaurant(Restaurant restaurant);
}
