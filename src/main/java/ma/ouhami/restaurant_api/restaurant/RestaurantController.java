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
    @GetMapping
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/findRestaurant")
    public Restaurant findByName(@RequestParam("name") String name) {
        return restaurantService.findByName(name);
    }

    // Post methods
    @PostMapping("create")
    @ResponseBody
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
    }


    // Update methods
    @PutMapping("update/{id}")
    @ResponseBody
    public void updateRestaurant(
        @PathVariable Integer id,
        @RequestBody Restaurant restaurant)
        {
            restaurantService.updateRestaurant(id, restaurant);
        }

    // Delete methods
    @DeleteMapping("delete/{id}")
    public void deleteRestaurant(@PathVariable Integer id){
        restaurantService.deleteRestaurant(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAll(){
        restaurantService.deleteAll();
    }

    @DeleteMapping("deleteMass")
    public void deleteRestaurants(@RequestBody List<Integer> restaurant_ids){
        restaurantService.deleteRestaurants(restaurant_ids);
    }

}
