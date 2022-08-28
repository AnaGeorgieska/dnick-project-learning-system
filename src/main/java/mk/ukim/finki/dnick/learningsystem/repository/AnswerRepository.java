package mk.ukim.finki.dnick.learningsystem.repository;

import mk.ukim.finki.dnick.learningsystem.model.Answer;
import mk.ukim.finki.dnick.learningsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAll();
    List<Answer> findAllByUser(User user);
    @Override
    void delete(Answer answer);
}