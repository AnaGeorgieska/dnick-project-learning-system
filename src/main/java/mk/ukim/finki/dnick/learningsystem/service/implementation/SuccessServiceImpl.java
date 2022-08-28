package mk.ukim.finki.dnick.learningsystem.service.implementation;

import mk.ukim.finki.dnick.learningsystem.model.Answer;
import mk.ukim.finki.dnick.learningsystem.model.AnswerOption;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.AnswerService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.SuccessService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuccessServiceImpl implements SuccessService {

    private final UserService userService;
    private final AnswerService answerService;

    public SuccessServiceImpl(UserService userService, AnswerService answerService) {
        this.userService = userService;
        this.answerService = answerService;
    }

    @Override
    public double calculateTotalSuccess(String username) {
        List<Answer> answers=answerService.findAllByUser(username);
        List<AnswerOption> answerOptions= answers.stream().map(Answer::getAnswerOption).toList();
        List<AnswerOption> trueAnswerOptions = answerOptions.stream().filter(AnswerOption::isCorrect).toList();
        double temp = (trueAnswerOptions.size() * 1.0 / 12);
        double temp2 = Math.round(temp*100);
        double temp3 = temp2;
        if(trueAnswerOptions.size()==0)
            return 0;
        else return temp3;
    }
    @Override
    public double calculateFloodTestSuccess(String username) {
        List<Answer> answers = answerService.findAllByUser(username);
        List<AnswerOption> answerOptions = answers.stream().map(Answer::getAnswerOption).toList();
        List<AnswerOption> floodAnswerOptions = answerOptions.stream().filter(answerOption -> {
            return answerOption.getQuestion().getCourse().getCourseName().equals("Flood");
        }).toList();
        List<AnswerOption> trueAnswerOptions = floodAnswerOptions.stream().filter(AnswerOption::isCorrect).toList();
        double temp = (trueAnswerOptions.size() * 1.0 / 4);
        double temp2 = Math.round(temp*100);
        double temp3 = temp2;
        if(trueAnswerOptions.size()==0)
            return 0;
        else return temp3;
    }
    @Override
    public double calculateFireTestSuccess(String username) {
        List<Answer> answers=answerService.findAllByUser(username);
        List<AnswerOption> answerOptions= answers.stream().map(Answer::getAnswerOption).toList();
        List<AnswerOption> fireAnswerOptions = answerOptions.stream().filter(answerOption -> {
            return answerOption.getQuestion().getCourse().getCourseName().equals("Fire");
        }).toList();
        List<AnswerOption> trueAnswerOptions = fireAnswerOptions.stream().filter(AnswerOption::isCorrect).toList();
        double temp = (trueAnswerOptions.size() * 1.0 / 4);
        double temp2 = Math.round(temp*100);
        double temp3 = temp2;
        if(trueAnswerOptions.size()==0)
            return 0;
        else return temp3;
    }
    @Override
    public double calculateEarthquakeTestSuccess(String username) {
        List<Answer> answers=answerService.findAllByUser(username);
        List<AnswerOption> answerOptions= answers.stream().map(Answer::getAnswerOption).toList();
        List<AnswerOption> earthquakeAnswerOptions = answerOptions.stream().filter(answerOption -> {
            return answerOption.getQuestion().getCourse().getCourseName().equals("Earthquake");
        }).toList();
        List<AnswerOption> trueAnswerOptions = earthquakeAnswerOptions.stream().filter(AnswerOption::isCorrect).toList();
        double temp = (trueAnswerOptions.size() * 1.0 / 4);
        double temp2 = Math.round(temp*100);
        double temp3 = temp2;
        if(trueAnswerOptions.size()==0)
            return 0;
        else return temp3;
    }
}
