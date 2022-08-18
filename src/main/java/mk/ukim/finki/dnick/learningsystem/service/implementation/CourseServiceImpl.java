package mk.ukim.finki.dnick.learningsystem.service.implementation;

import mk.ukim.finki.dnick.learningsystem.model.Course;
import mk.ukim.finki.dnick.learningsystem.repository.CourseRepository;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.CourseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> findByCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }
}
