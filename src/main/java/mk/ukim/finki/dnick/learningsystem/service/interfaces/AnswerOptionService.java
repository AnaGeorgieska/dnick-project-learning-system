package mk.ukim.finki.dnick.learningsystem.service.interfaces;

import mk.ukim.finki.dnick.learningsystem.model.AnswerOption;

import java.util.Optional;

public interface AnswerOptionService {

    public Optional<AnswerOption> findById(Long id);
}
