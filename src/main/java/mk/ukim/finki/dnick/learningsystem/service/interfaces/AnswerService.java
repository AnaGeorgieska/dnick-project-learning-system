package mk.ukim.finki.dnick.learningsystem.service.interfaces;

import mk.ukim.finki.dnick.learningsystem.model.Answer;

import java.util.List;

public interface AnswerService {
    public List<Answer> findAllByUser(String username);
}
