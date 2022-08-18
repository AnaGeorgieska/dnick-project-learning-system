package mk.ukim.finki.dnick.learningsystem.repository;

import mk.ukim.finki.dnick.learningsystem.model.Course;
import mk.ukim.finki.dnick.learningsystem.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAll();
    List<Question> findAllByCourse(Course course);
}