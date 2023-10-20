package ma.ouhami.restaurant_api.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
    // The Repository is the linking point between the app and the database

    public Restaurant findByName(String name);
}
