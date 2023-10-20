package ma.ouhami.restaurant_api.admin;

import jakarta.persistence.Entity;
import lombok.Data;
import ma.ouhami.restaurant_api.user.User;

@Entity
@Data
public class Admin extends User{
    
}
