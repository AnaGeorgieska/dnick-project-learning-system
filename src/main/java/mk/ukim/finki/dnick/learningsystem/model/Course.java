package mk.ukim.finki.dnick.learningsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Question> questions;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
