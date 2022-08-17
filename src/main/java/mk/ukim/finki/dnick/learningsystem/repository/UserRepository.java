package mk.ukim.finki.dnick.learningsystem.repository;

import mk.ukim.finki.dnick.learningsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
