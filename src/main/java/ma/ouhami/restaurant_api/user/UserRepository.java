package ma.ouhami.restaurant_api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
    
    // Custom methods
    
    public User findByEmail(String email);
    public void deleteByEmail(String email);
}
