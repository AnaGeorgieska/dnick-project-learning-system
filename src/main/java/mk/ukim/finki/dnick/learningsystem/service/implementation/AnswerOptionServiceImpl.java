package mk.ukim.finki.dnick.learningsystem.service.implementation;

import mk.ukim.finki.dnick.learningsystem.model.AnswerOption;
import mk.ukim.finki.dnick.learningsystem.repository.AnswerOptionRepository;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.AnswerOptionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerOptionServiceImpl implements AnswerOptionService {
    private final AnswerOptionRepository answerOptionRepository;

    public AnswerOptionServiceImpl(AnswerOptionRepository answerOptionRepository) {
        this.answerOptionRepository = answerOptionRepository;
    }

    @Override
    public Optional<AnswerOption> findById(Long id) {
        return answerOptionRepository.findById(id);
    }
}
