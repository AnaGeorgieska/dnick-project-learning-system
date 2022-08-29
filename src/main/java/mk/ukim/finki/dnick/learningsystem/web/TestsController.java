package mk.ukim.finki.dnick.learningsystem.web;

import mk.ukim.finki.dnick.learningsystem.model.*;
import mk.ukim.finki.dnick.learningsystem.model.exceptions.CourseDoesNotExistException;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.AnswerService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.CourseService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.QuestionService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestsController {
    private final CourseService courseService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

    public TestsController(CourseService courseService, QuestionService questionService, AnswerService answerService, UserService userService) {
        this.courseService = courseService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.userService = userService;
    }

    @GetMapping("/fire")
    public String getFirePage(Model model, HttpServletRequest request) {
        Course course;
        if(courseService.findByCourseName("Fire").isEmpty())
        {
           throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Fire").get();
        List<Question> questions = questionService.findAllByCourse(course);
        System.out.println(questions.toString());

        model.addAttribute("questions", questions);

        String username = request.getRemoteUser();
        User user = userService.findById(username);

        List<Answer> answersByUserAndCourse = answerService.findAllByUserAndCourse(username, "Fire");
        List<AnswerOption> answerOptionsByUserAndCourse = answersByUserAndCourse.stream().map(Answer::getAnswerOption).toList();

        model.addAttribute("answers", answerOptionsByUserAndCourse);
        return "fireTest";
    }
    @GetMapping("/flood")
    public String getFloodPage(Model model, HttpServletRequest request) {
        Course course;
        if(courseService.findByCourseName("Flood").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Flood").get();
        List<Question> questions = questionService.findAllByCourse(course);
        System.out.println(questions.toString());
        model.addAttribute("questions", questions);
        String username = request.getRemoteUser();
        User user = userService.findById(username);

        List<Answer> answersByUserAndCourse = answerService.findAllByUserAndCourse(username, "Flood");
        List<AnswerOption> answerOptionsByUserAndCourse = answersByUserAndCourse.stream().map(Answer::getAnswerOption).toList();

        model.addAttribute("answers", answerOptionsByUserAndCourse);

        return "floodTest";
    }
    @GetMapping("/earthquake")
    public String getEarthquakeage(Model model, HttpServletRequest request) {
        Course course;
        if(courseService.findByCourseName("Earthquake").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Earthquake").get();
        List<Question> questions = questionService.findAllByCourse(course);
        model.addAttribute("questions", questions);
        String username = request.getRemoteUser();
        User user = userService.findById(username);

        List<Answer> answersByUserAndCourse = answerService.findAllByUserAndCourse(username, "Earthquake");
        List<AnswerOption> answerOptionsByUserAndCourse = answersByUserAndCourse.stream().map(Answer::getAnswerOption).toList();

        model.addAttribute("answers", answerOptionsByUserAndCourse);
        return "earthquakeTest";
    }
}

