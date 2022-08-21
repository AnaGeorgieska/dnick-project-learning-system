package mk.ukim.finki.dnick.learningsystem.service.interfaces;

import mk.ukim.finki.dnick.learningsystem.model.User;

public interface AuthService {
    User login(String username, String password);
}
