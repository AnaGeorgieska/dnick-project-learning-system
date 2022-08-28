package mk.ukim.finki.dnick.learningsystem.web;

import mk.ukim.finki.dnick.learningsystem.model.*;
import mk.ukim.finki.dnick.learningsystem.model.exceptions.CourseDoesNotExistException;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionsController {
    private final QuestionService questionService;
    private final CourseService courseService;
    private final AnswerOptionService answerOptionService;
    private final UserService userService;
    private final AnswerService answerService;
    private final SuccessService successService;

    public QuestionsController(QuestionService questionService, CourseService courseService, AnswerOptionService answerOptionService, UserService userService, AnswerService answerService, SuccessService successService) {
        this.questionService = questionService;
        this.courseService = courseService;
        this.answerOptionService = answerOptionService;
        this.userService = userService;
        this.answerService = answerService;
        this.successService = successService;
    }
    @GetMapping("/fire/1")
    public String getFireQuestion1(Model model, HttpServletRequest request) {
        Course course;
        if(courseService.findByCourseName("Fire").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Fire").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(0);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            List<Answer> answers = answerService.findAllByUserAndCourse(username, "Fire");
            System.out.println(answers.toString());
            for (Answer a : answers) {
                answerService.delete(a);
            }
        }
        return "fireQ1";
    }
    @GetMapping("/fire/2")
    public String getFireQuestion2(Model model) {
        Course course;
        if(courseService.findByCourseName("Fire").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Fire").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(1);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "fireQ2";
    }
    @GetMapping("/fire/3")
    public String getFireQuestion3(Model model) {
        Course course;
        if(courseService.findByCourseName("Fire").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Fire").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(2);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "fireQ3";
    }
    @GetMapping("/fire/4")
    public String getFireQuestion4(Model model) {
        Course course;
        if(courseService.findByCourseName("Fire").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Fire").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(3);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "fireQ4";
    }

    @GetMapping("/flood/1")
    public String getFloodQuestion1(Model model, HttpServletRequest request) {
        Course course;
        if(courseService.findByCourseName("Flood").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Flood").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(0);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            List<Answer> answers = answerService.findAllByUserAndCourse(username, "Flood");
            System.out.println(answers.toString());
            for (Answer a : answers) {
                answerService.delete(a);
            }
        }
        return "floodQ1";
    }

    @GetMapping("/flood/2")
    public String getFloodQuestion2(Model model) {
        Course course;
        if(courseService.findByCourseName("Flood").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Flood").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(1);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "floodQ2";
    }
    @GetMapping("/flood/3")
    public String getFloodQuestion3(Model model) {
        Course course;
        if(courseService.findByCourseName("Flood").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Flood").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(2);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "floodQ3";
    }
    @GetMapping("/flood/4")
    public String getFloodQuestion4(Model model) {
        Course course;
        if(courseService.findByCourseName("Flood").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Flood").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(3);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "floodQ4";
    }

    @GetMapping("/earthquake/1")
    public String getEarthquakeQuestion1(Model model, HttpServletRequest request) {
        Course course;
        if(courseService.findByCourseName("Earthquake").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Earthquake").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(0);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            List<Answer> answers = answerService.findAllByUserAndCourse(username, "Earthquake");
            System.out.println(answers.toString());
            for (Answer a : answers) {
                answerService.delete(a);
            }
        }
        return "earthquakeQ1";
    }
    @GetMapping("/earthquake/2")
    public String getEarthquakeQuestion2(Model model) {
        Course course;
        if(courseService.findByCourseName("Earthquake").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Earthquake").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(1);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "earthquakeQ2";
    }
    @GetMapping("/earthquake/3")
    public String getEarthquakeQuestion3(Model model) {
        Course course;
        if(courseService.findByCourseName("Earthquake").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Earthquake").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(2);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "earthquakeQ3";
    }
    @GetMapping("/earthquake/4")
    public String getEarthquakeQuestion4(Model model) {
        Course course;
        if(courseService.findByCourseName("Earthquake").isEmpty())
        {
            throw new CourseDoesNotExistException();
        }
        course = courseService.findByCourseName("Earthquake").get();
        List<Question> questions = questionService.findAllByCourse(course);
        Question question = questions.get(3);
        System.out.println(question.toString());
        model.addAttribute("question", question);
        return "earthquakeQ4";
    }


    @PostMapping("/flood/q1")
    public String postFloodQuestion1(@RequestParam(required = false) Long floodQ1, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("floodAO1");
        if(floodQ1 != null)
        {
            answerOption = answerOptionService.findById(floodQ1).get();
            session.setAttribute("floodAO1", answerOption);
        }
        return "redirect:/question/flood/2";
    }

    @PostMapping("/flood/q2")
    public String postFloodQuestion2(@RequestParam(required = false) Long floodQ2, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("floodAO2");
        if(floodQ2 != null)
        {
            answerOption = answerOptionService.findById(floodQ2).get();
            session.setAttribute("floodAO2", answerOption);
            System.out.println(session.getAttribute("floodAO2").toString());

        }
        return "redirect:/question/flood/3";
    }
    @PostMapping("/flood/q3")
    public String postFloodQuestion3(@RequestParam(required = false) Long floodQ3, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("floodAO3");
        if(floodQ3 != null)
        {
            answerOption = answerOptionService.findById(floodQ3).get();
            session.setAttribute("floodAO3", answerOption);
            System.out.println(session.getAttribute("floodAO3").toString());

        }
        return "redirect:/question/flood/4";
    }
    @PostMapping("/flood/q4")
    public String postFloodQuestion4(@RequestParam(required = false) Long floodQ4, HttpSession session, HttpServletRequest request ) {
        AnswerOption answerOption;
        session.removeAttribute("floodAO4");
        if(floodQ4 != null)
        {
            answerOption = answerOptionService.findById(floodQ4).get();
            session.setAttribute("floodAO4", answerOption);
            System.out.println(session.getAttribute("floodAO4").toString());
        }

        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            if(session.getAttribute("floodAO1") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("floodAO1");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("floodAO2") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("floodAO2");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("floodAO3") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("floodAO3");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("floodAO4") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("floodAO4");
                answerService.save(new Answer(user, ao));
            }
            System.out.println(successService.calculateTotalSuccess(user.getUsername())+"totalSucc");
            System.out.println(successService.calculateFloodTestSuccess(user.getUsername()));
        }
        return "redirect:/success/flood";
    }
    @PostMapping("/fire/q1")
    public String postFireQuestion1(@RequestParam(required = false) Long fireQ1, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("fireAO1");
        if(fireQ1 != null)
        {
            answerOption = answerOptionService.findById(fireQ1).get();
            session.setAttribute("fireAO1", answerOption);
        }
        return "redirect:/question/fire/2";
    }

    @PostMapping("/fire/q2")
    public String postFireQuestion2(@RequestParam(required = false) Long fireQ2, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("fireAO2");
        if(fireQ2 != null)
        {
            answerOption = answerOptionService.findById(fireQ2).get();
            session.setAttribute("fireAO2", answerOption);
        }
        return "redirect:/question/fire/3";
    }
    @PostMapping("/fire/q3")
    public String postFireQuestion3(@RequestParam(required = false) Long fireQ3, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("fireAO3");
        if(fireQ3 != null)
        {
            answerOption = answerOptionService.findById(fireQ3).get();
            session.setAttribute("fireAO3", answerOption);
        }
        return "redirect:/question/fire/4";
    }
    @PostMapping("/fire/q4")
    public String postFireQuestion4(@RequestParam(required = false) Long fireQ4, HttpSession session, HttpServletRequest request ) {
        AnswerOption answerOption;
        session.removeAttribute("fireAO4");
        if(fireQ4 != null)
        {
            answerOption = answerOptionService.findById(fireQ4).get();
            session.setAttribute("fireAO4", answerOption);
        }

        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            if(session.getAttribute("fireAO1") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("fireAO1");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("fireAO2") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("fireAO2");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("fireAO3") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("fireAO3");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("fireAO4") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("fireAO4");
                answerService.save(new Answer(user, ao));
            }
            System.out.println(successService.calculateTotalSuccess(user.getUsername())+"totalSucc");
            System.out.println(successService.calculateFireTestSuccess(user.getUsername())+"fire");
        }
        return "redirect:/success/fire";
    }
    @PostMapping("/earthquake/q1")
    public String postEarthquakeQuestion1(@RequestParam(required = false) Long earthquakeQ1, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("earthquakeAO1");
        if(earthquakeQ1 != null)
        {
            answerOption = answerOptionService.findById(earthquakeQ1).get();
            session.setAttribute("earthquakeAO1", answerOption);
        }
        return "redirect:/question/earthquake/2";
    }

    @PostMapping("/earthquake/q2")
    public String postearthquakeQuestion2(@RequestParam(required = false) Long earthquakeQ2, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("earthquakeAO2");
        if(earthquakeQ2 != null)
        {
            answerOption = answerOptionService.findById(earthquakeQ2).get();
            session.setAttribute("earthquakeAO2", answerOption);
        }
        return "redirect:/question/earthquake/3";
    }
    @PostMapping("/earthquake/q3")
    public String postearthquakeQuestion3(@RequestParam(required = false) Long earthquakeQ3, HttpSession session ) {
        AnswerOption answerOption;
        session.removeAttribute("earthquakeAO3");
        if(earthquakeQ3 != null)
        {
            answerOption = answerOptionService.findById(earthquakeQ3).get();
            session.setAttribute("earthquakeAO3", answerOption);
        }
        return "redirect:/question/earthquake/4";
    }
    @PostMapping("/earthquake/q4")
    public String postearthquakeQuestion4(@RequestParam(required = false) Long earthquakeQ4, HttpSession session, HttpServletRequest request ) {
        AnswerOption answerOption;
        session.removeAttribute("earthquakeAO4");
        if(earthquakeQ4 != null)
        {
            answerOption = answerOptionService.findById(earthquakeQ4).get();
            session.setAttribute("earthquakeAO4", answerOption);
        }

        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            if(session.getAttribute("earthquakeAO1") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("earthquakeAO1");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("earthquakeAO2") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("earthquakeAO2");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("earthquakeAO3") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("earthquakeAO3");
                answerService.save(new Answer(user, ao));
            }
            if(session.getAttribute("earthquakeAO4") != null)
            {
                AnswerOption ao= (AnswerOption) session.getAttribute("earthquakeAO4");
                answerService.save(new Answer(user, ao));
            }
            System.out.println(successService.calculateTotalSuccess(user.getUsername())+"totalSucc");
            System.out.println(successService.calculateEarthquakeTestSuccess(user.getUsername())+"earth");
        }
        return "redirect:/success/earthquake";
    }
}
