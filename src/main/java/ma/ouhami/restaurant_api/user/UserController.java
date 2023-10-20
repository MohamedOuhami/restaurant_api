package ma.ouhami.restaurant_api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.mindrot.jbcrypt.BCrypt;

import ma.ouhami.restaurant_api.admin.Admin;
import ma.ouhami.restaurant_api.customer.Customer;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get methods

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findUser")
    public User findByEmail(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    // Post method
    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody Customer customer) {

        // Hash a password
        String rawPassword = customer.getPassword();
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        customer.setPassword(hashedPassword);

        userService.createuser(customer);
    }

    @PostMapping("/createAdmin")
    public void createAdmin(@RequestBody Admin admin) {

         // Hash a password
        String rawPassword = admin.getPassword();
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        admin.setPassword(hashedPassword);
        
        userService.createuser(admin);
    }

    // Put methods
    @PutMapping("/updateUser")
    public void updateUser(
            @RequestParam Integer id,
            @RequestBody User user) {
        userService.updateuser(
                id,
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getPassword());
    }

    // Delete methods
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        userService.deleteAll();
    }

    @DeleteMapping("/delete")
    public void deleteByEmail(@RequestParam("email") String email) {
        userService.deleteByEmail(email);
        ;
    }

}
