package ma.ouhami.restaurant_api.user;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get Method

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Post method

    public void createuser(User user) {
        userRepository.save(user);
    }

    // Put method

    public void updateuser(Integer id, String first_name, String last_name, String email, String password) {
        User user = userRepository.findById(id).get();

        // Change the email
        if (email != null && !email.isEmpty()) {
            user.setEmail(email);
        }

        // Change the first name
        if (first_name != null && !first_name.isEmpty()) {
            user.setFirst_name(first_name);
        }

        // Change the last_email
        if (last_name != null && !last_name.isEmpty()) {
            user.setLast_name(last_name);
        }

        // Change the password
        if (password != null && !password.isEmpty()) {

            // Hash a password;
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setPassword(hashedPassword);
        }

        userRepository.save(user);

    }

    // Delete method

    public void deleteAll() {
        userRepository.deleteAll();
        ;
    }

    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
