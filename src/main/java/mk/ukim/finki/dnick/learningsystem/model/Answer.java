package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
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
}
