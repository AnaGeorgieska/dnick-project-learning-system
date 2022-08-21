package mk.ukim.finki.dnick.learningsystem.service.interfaces;

import mk.ukim.finki.dnick.learningsystem.model.Role;
import mk.ukim.finki.dnick.learningsystem.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User save(String username, String password, String name, String surname, String country);
    public User findById(String username);
    User register(String username, String password, String repeatPassword, String name, String surname, Role role, String country);

}
