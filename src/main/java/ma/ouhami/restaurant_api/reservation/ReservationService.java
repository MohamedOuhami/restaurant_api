package ma.ouhami.restaurant_api.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.ouhami.restaurant_api.customer.Customer;
import ma.ouhami.restaurant_api.restaurant.Restaurant;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    // Get methods

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public Reservation findById(ReservationCP id){
        return reservationRepository.findById(id).get();
    }

    public List<Reservation> findByCustomer(Customer customer){
        return reservationRepository.findByCustomer(customer);
    }

    public List<Reservation> findByRestaurant(Restaurant restaurant){
        return reservationRepository.findByRestaurant(restaurant);
    }

    // Post methods

    public void createReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    // Delete methods

    public void deleteAll(){
        reservationRepository.deleteAll();
    }

    public void deleteById(ReservationCP id){
        reservationRepository.deleteById(id);
    }

}
