package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnswerOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answerOption;
    private boolean isCorrect;

    public AnswerOption(String answerOption, boolean isCorrect) {
        this.answerOption = answerOption;
        this.isCorrect = isCorrect;
    }

    public AnswerOption() {
    }

    public Long getId() {
        return id;
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
