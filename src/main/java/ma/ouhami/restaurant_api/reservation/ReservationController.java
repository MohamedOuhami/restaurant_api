package ma.ouhami.restaurant_api.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.ouhami.restaurant_api.customer.Customer;
import ma.ouhami.restaurant_api.restaurant.Restaurant;
import ma.ouhami.restaurant_api.restaurant.RestaurantService;
import ma.ouhami.restaurant_api.user.User;
import ma.ouhami.restaurant_api.user.UserService;

@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    // Get methods
    @GetMapping("/allReservations")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/reservation")

    public Reservation findById(
            @RequestParam("restaurant") Restaurant restaurant,
            @RequestParam("customer") Customer customer) {
        ReservationCP id = new ReservationCP(restaurant, customer);
        return reservationService.findById(id);

    }

    // Post methods
    @PostMapping("/createReservation")
    public void createReservation(@RequestBody ReservationRequest reservationRequest) {

        User customer = userService.findById(reservationRequest.getCustomer_id());
        Restaurant restaurant = restaurantService.findById(reservationRequest.getRestaurant_id());
        reservationService.createReservation(new Reservation((Customer) customer, restaurant));
    }

    // Delete methods
    @DeleteMapping("/deleteReservations")
    public void deleteReservations() {
        reservationService.deleteAll();
    }

    @DeleteMapping("/deleteReservation")
    public void deleteById(@RequestBody ReservationRequest reservationRequest) {

        User customer = userService.findById(reservationRequest.getCustomer_id());
        Restaurant restaurant = restaurantService.findById(reservationRequest.getRestaurant_id());
        ReservationCP composte_key = new ReservationCP(restaurant,(Customer) customer);

        reservationService.deleteById(composte_key);
    }
}
