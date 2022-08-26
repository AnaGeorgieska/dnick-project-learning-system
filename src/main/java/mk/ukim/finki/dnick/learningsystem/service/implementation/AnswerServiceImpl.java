package mk.ukim.finki.dnick.learningsystem.service.implementation;

import mk.ukim.finki.dnick.learningsystem.model.Answer;
import mk.ukim.finki.dnick.learningsystem.model.User;
import mk.ukim.finki.dnick.learningsystem.repository.AnswerRepository;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.AnswerService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final UserService userService;
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(UserService userService, AnswerRepository answerRepository) {
        this.userService = userService;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> findAllByUser(String username) {
        User user=userService.findById(username);
        return answerRepository.findAllByUser(user);
    }
}
