package mk.ukim.finki.dnick.learningsystem.web;

import mk.ukim.finki.dnick.learningsystem.model.Course;
import mk.ukim.finki.dnick.learningsystem.model.Question;
import mk.ukim.finki.dnick.learningsystem.model.exceptions.CourseDoesNotExistException;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.CourseService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/test")
public class TestsController {
    private final CourseService courseService;
    private final QuestionService questionService;

    public TestsController(CourseService courseService, QuestionService questionService) {
        this.courseService = courseService;
        this.questionService = questionService;
    }

    @GetMapping("/fire")
    public String getFirePage(Model model) {
        Course course;
        if(courseService.findByCourseName("Fire").isEmpty())
        {
           throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Fire").get();
        List<Question> questions = questionService.findAllByCourse(course);
        System.out.println(questions.toString());

        model.addAttribute("questions", questions);
        return "fireTest";
    }
    @GetMapping("/flood")
    public String getFloodPage(Model model) {
        Course course;
        if(courseService.findByCourseName("Flood").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Flood").get();
        List<Question> questions = questionService.findAllByCourse(course);
        System.out.println(questions.toString());
        model.addAttribute("questions", questions);
        return "floodTest";
    }
    @GetMapping("/earthquake")
    public String getEarthquakeage(Model model) {
        Course course;
        if(courseService.findByCourseName("Earthquake").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Earthquake").get();
        List<Question> questions = questionService.findAllByCourse(course);
        model.addAttribute("questions", questions);
        return "earthquakeTest";
    }
}

