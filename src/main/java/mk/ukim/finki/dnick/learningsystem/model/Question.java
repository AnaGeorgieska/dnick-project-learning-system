package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionTitle;
    @OneToMany
    private List<AnswerOption> answerOptions;

    public Question(String questionTitle, List<AnswerOption> answerOptions) {
        this.questionTitle = questionTitle;
        this.answerOptions = answerOptions;
    }

    public Question() {
        answerOptions=new ArrayList<>();
    }
}
