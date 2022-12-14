package mk.ukim.finki.dnick.learningsystem.repository;

import mk.ukim.finki.dnick.learningsystem.model.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
    List<AnswerOption> findAll();
}