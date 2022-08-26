package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public class AnswerOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answerOption;
    private boolean isCorrect;

    @ManyToOne
    private Question question;

    public AnswerOption(String answerOption, boolean isCorrect) {
        this.answerOption = answerOption;
        this.isCorrect = isCorrect;
    }
    public AnswerOption(String answerOption, boolean isCorrect, Question question) {
        this.answerOption = answerOption;
        this.isCorrect = isCorrect;
        this.question=question;
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

    public Question getQuestion() {
        return question;
    }
}
