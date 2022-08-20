package mk.ukim.finki.dnick.learningsystem.config;

import mk.ukim.finki.dnick.learningsystem.model.AnswerOption;
import mk.ukim.finki.dnick.learningsystem.model.Course;
import mk.ukim.finki.dnick.learningsystem.model.Question;
import mk.ukim.finki.dnick.learningsystem.repository.AnswerOptionRepository;
import mk.ukim.finki.dnick.learningsystem.repository.CourseRepository;
import mk.ukim.finki.dnick.learningsystem.repository.QuestionRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    private final QuestionRepository questionRepository;
    private final AnswerOptionRepository answerOptionRepository;
    private final CourseRepository courseRepository;


    public DataInitializer(QuestionRepository questionRepository, AnswerOptionRepository answerOptionRepository, CourseRepository courseRepository) {
        this.questionRepository=questionRepository;
        this.answerOptionRepository = answerOptionRepository;
        this.courseRepository = courseRepository;
    }

    @PostConstruct
    public void initData() {
        Course fireCourse = courseRepository.save(new Course("Fire"));
        AnswerOption answerOption1 = this.answerOptionRepository.save(new AnswerOption("Hurry up to collect all the valuable items from the house that you do not want to burn", false));
        AnswerOption answerOption2 = this.answerOptionRepository.save(new AnswerOption("Try to put out the fire in every possible way", false));
        AnswerOption answerOption3 = this.answerOptionRepository.save(new AnswerOption("Cover your mouth and nose with a cloth and get out of the house as soon as possible", true));
        List<AnswerOption> answerOptionList = new ArrayList<>();
        answerOptionList.add(answerOption1);
        answerOptionList.add(answerOption2);
        answerOptionList.add(answerOption3);
        Question fireQuestion = this.questionRepository.save(new Question("A fire suddenly breaks out in the home. Before calling the fire department, you should ... ", answerOptionList,fireCourse));

        Course EarthCourse = courseRepository.save(new Course("Earthquake"));

        AnswerOption answerOption4 = this.answerOptionRepository.save(new AnswerOption("Stay in the house and take shelter", false));
        AnswerOption answerOption5 = this.answerOptionRepository.save(new AnswerOption("Call your loved ones, notify them or write Facebook status", false));
        AnswerOption answerOption6 = this.answerOptionRepository.save(new AnswerOption("Stay calm and get out of the house as soon as you can ", true));
        List<AnswerOption> answerOptionList2 = new ArrayList<>();
        answerOptionList2.add(answerOption4);
        answerOptionList2.add(answerOption5);
        answerOptionList2.add(answerOption6);
        Question earthQuestion2 = this.questionRepository.save(new Question("You are in a house on one floor, when an earthquake suddenly starts. What should you do? ", answerOptionList2, EarthCourse));

        AnswerOption answerOption7 = this.answerOptionRepository.save(new AnswerOption("As soon as you feel it go down the stairs or elevator and leave the building", false));
        AnswerOption answerOption8 = this.answerOptionRepository.save(new AnswerOption("Stay calm, take shelter while it lasts and wait for it to stop so you can slowly leave the building ", true));
        AnswerOption answerOption9 = this.answerOptionRepository.save(new AnswerOption("Hug your loved ones and sit hidden somewhere in the house  ", false));
        List<AnswerOption> answerOptionList3 = new ArrayList<>();
        answerOptionList3.add(answerOption7);
        answerOptionList3.add(answerOption8);
        answerOptionList3.add(answerOption9);
        Question earthQuestion3 = this.questionRepository.save(new Question("You are in a building when an earthquake suddenly starts. What should you do? ", answerOptionList3, EarthCourse));


        Course floodCourse = courseRepository.save(new Course("Flood"));

        AnswerOption answerOption10 = this.answerOptionRepository.save(new AnswerOption("Get in the water and see what happens", false));
        AnswerOption answerOption11 = this.answerOptionRepository.save(new AnswerOption("Stay on the beach and observe the situation and the movement of water", false));
        AnswerOption answerOption12 = this.answerOptionRepository.save(new AnswerOption("Move away as fast as possible and climb to the highest place", true));
        List<AnswerOption> answerOptionList4 = new ArrayList<>();
        answerOptionList4.add(answerOption10);
        answerOptionList4.add(answerOption11);
        answerOptionList4.add(answerOption12);
        Question floodQuestion4 = this.questionRepository.save(new Question("Imagine that you are on the beach and suddenly you see that the water from the ocean begins to recede sharply. What should you do?", answerOptionList4, floodCourse));

        AnswerOption answerOption13 = this.answerOptionRepository.save(new AnswerOption("Try to start the car and move the vehicle to the surface", false));
        AnswerOption answerOption14 = this.answerOptionRepository.save(new AnswerOption("Break the window with a piece of clothing and go out", true));
        AnswerOption answerOption15 = this.answerOptionRepository.save(new AnswerOption("To play until someone hears and comes to your rescue", false));
        List<AnswerOption> answerOptionList5 = new ArrayList<>();
        answerOptionList5.add(answerOption13);
        answerOptionList5.add(answerOption14);
        answerOptionList5.add(answerOption15);
        Question floodQuestion5 = this.questionRepository.save(new Question("Imagine that while driving a car, the vehicle loses control and falls into a lake. The car starts to sink and you do not have much time to save yourself, what should you do?", answerOptionList5, floodCourse));
    }
}
