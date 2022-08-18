package mk.ukim.finki.dnick.learningsystem.service.implementation;

import mk.ukim.finki.dnick.learningsystem.model.Course;
import mk.ukim.finki.dnick.learningsystem.model.Question;
import mk.ukim.finki.dnick.learningsystem.repository.QuestionRepository;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAllByCourse(Course course)
    {
        return questionRepository.findAllByCourse(course);
    }
}
