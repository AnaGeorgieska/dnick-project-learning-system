package mk.ukim.finki.dnick.learningsystem.service.interfaces;

import mk.ukim.finki.dnick.learningsystem.model.Course;

import java.util.Optional;

public interface CourseService {
    public Optional<Course> findByCourseName(String courseName);
}
