package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionTitle;
    @OneToMany
    private List<AnswerOption> answerOptions;
    @ManyToOne
    private Course course;

    public Question(String questionTitle, List<AnswerOption> answerOptions, Course course) {
        this.questionTitle = questionTitle;
        this.answerOptions = answerOptions;
        this.course=course;
    }

    public Question() {
        answerOptions=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public Course getCourse() {
        return course;
    }
}
