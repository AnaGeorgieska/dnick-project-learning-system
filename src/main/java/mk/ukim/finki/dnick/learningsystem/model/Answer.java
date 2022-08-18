package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.*;


@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Question question;
    @ManyToOne
    private User user;
    @ManyToOne
    private AnswerOption answerOption;

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public User getUser() {
        return user;
    }

    public AnswerOption getAnswerOption() {
        return answerOption;
    }
}
