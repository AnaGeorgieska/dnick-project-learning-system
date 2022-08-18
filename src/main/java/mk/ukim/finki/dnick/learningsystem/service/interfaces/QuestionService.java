package mk.ukim.finki.dnick.learningsystem.service.interfaces;

import mk.ukim.finki.dnick.learningsystem.model.Course;
import mk.ukim.finki.dnick.learningsystem.model.Question;

import java.util.List;

public interface QuestionService {
    public List<Question> findAllByCourse(Course course);
}
