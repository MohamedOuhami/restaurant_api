package ma.ouhami.restaurant_api.restaurant;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import ma.ouhami.restaurant_api.reservation.Reservation;

@Entity
@Data
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String adresse;
    private String phone;

    @OneToMany(mappedBy = "restaurant")
    private Set<Reservation> reservations = new HashSet<>(); 

}
