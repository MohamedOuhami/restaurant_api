package ma.ouhami.restaurant_api.customer;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import ma.ouhami.restaurant_api.reservation.Reservation;
import ma.ouhami.restaurant_api.user.User;

@Entity
public class Customer extends User{
    
    @OneToMany(mappedBy="customer")
    private Set<Reservation> reservations = new HashSet<>();
}
