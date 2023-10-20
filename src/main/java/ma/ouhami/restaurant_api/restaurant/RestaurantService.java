package ma.ouhami.restaurant_api.restaurant;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Get methods
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant findByName(String name) {
        return restaurantRepository.findByName(name);
    }

    public Restaurant findById(Integer id){
        return restaurantRepository.findById(id).get();
    }

    // Post methods
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    // Update methods

    public void updateRestaurant(Integer id,Restaurant updated_res) {

        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        Restaurant restaurant = restaurantOptional.get();
        
        String adresse = updated_res.getAdresse();
        String name = updated_res.getName();
        String phone = updated_res.getPhone();

        if (adresse != null && !adresse.isEmpty()) {
            restaurant.setAdresse(adresse);
        }
        if (adresse != null && !name.isEmpty()) {
            restaurant.setName(name);
        }
        if (phone != null && !phone.isEmpty()) {
            restaurant.setPhone(phone);
        }

        restaurantRepository.save(restaurant);
    }

    // Delete methods
    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }

    public void deleteAll() {
        restaurantRepository.deleteAll();
    }

    public void deleteRestaurants(List<Integer> restaurant_ids) {
        restaurantRepository.deleteAll(restaurantRepository.findAllById(restaurant_ids));
    }

}
