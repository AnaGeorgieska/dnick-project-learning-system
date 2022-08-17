package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    @OneToMany
    private List<Question> questionList;

    public Course(String courseName, List<Question> questionList) {
        this.courseName = courseName;
        this.questionList = questionList;
    }

    public Course() {
    }
}
