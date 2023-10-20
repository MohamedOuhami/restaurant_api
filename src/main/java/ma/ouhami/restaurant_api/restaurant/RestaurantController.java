package ma.ouhami.restaurant_api.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Get methods
    @GetMapping("/allRestaurants")
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/restaurant")
    public Restaurant findByName(@RequestParam("name") String name) {
        return restaurantService.findByName(name);
    }

    // Post methods
    @PostMapping("/createRestaurant")
    @ResponseBody
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
    }


    // Update methods
    @PutMapping("/updateRestaurant")
    @ResponseBody
    public void updateRestaurant(
        @RequestParam Integer id,
        @RequestBody Restaurant restaurant)
        {
            restaurantService.updateRestaurant(id, restaurant);
        }

    // Delete methods
    @DeleteMapping("/deleteRestaurant")
    public void deleteRestaurant(@RequestParam Integer id){
        restaurantService.deleteRestaurant(id);
    }

    @DeleteMapping("/deleteRestaurants")
    public void deleteAll(){
        restaurantService.deleteAll();
    }

    @DeleteMapping("/deleteMass")
    public void deleteRestaurants(@RequestBody List<Integer> restaurant_ids){
        restaurantService.deleteRestaurants(restaurant_ids);
    }

}
