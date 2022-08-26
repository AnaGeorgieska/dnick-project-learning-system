package mk.ukim.finki.dnick.learningsystem.config;

import mk.ukim.finki.dnick.learningsystem.model.*;
import mk.ukim.finki.dnick.learningsystem.repository.AnswerOptionRepository;
import mk.ukim.finki.dnick.learningsystem.repository.AnswerRepository;
import mk.ukim.finki.dnick.learningsystem.repository.CourseRepository;
import mk.ukim.finki.dnick.learningsystem.repository.QuestionRepository;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.SuccessService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    private final QuestionRepository questionRepository;
    private final AnswerOptionRepository answerOptionRepository;
    private final CourseRepository courseRepository;
    private final UserService userService;
    private final AnswerRepository answerRepository;
    private final SuccessService successService;


    public DataInitializer(QuestionRepository questionRepository, AnswerOptionRepository answerOptionRepository, CourseRepository courseRepository, UserService userService, AnswerRepository answerRepository, SuccessService successService) {
        this.questionRepository=questionRepository;
        this.answerOptionRepository = answerOptionRepository;
        this.courseRepository = courseRepository;
        this.userService = userService;
        this.answerRepository = answerRepository;
        this.successService = successService;
    }

    @PostConstruct
    public void initData() {
        Course fireCourse = courseRepository.save(new Course("Fire"));

        Question fireQuestion = this.questionRepository.save(new Question("A fire suddenly breaks out in the home. Before calling the fire department, you should ... ",fireCourse));
        AnswerOption answerOption111 = this.answerOptionRepository.save(new AnswerOption("Hurry up and get out of the house as soon as possible", false, fireQuestion));
        AnswerOption answerOption1 = this.answerOptionRepository.save(new AnswerOption("Hurry up to collect all the valuable items from the house that you do not want to burn", false, fireQuestion));
        AnswerOption answerOption2 = this.answerOptionRepository.save(new AnswerOption("Try to put out the fire in every possible way", false, fireQuestion));
        AnswerOption answerOption3 = this.answerOptionRepository.save(new AnswerOption("Cover your mouth and nose with a cloth and get out of the house as soon as possible", true, fireQuestion));

        Question fireQuestion10 = this.questionRepository.save(new Question("Which three components are needed to start a fire?",fireCourse));
        AnswerOption answerOption30 = this.answerOptionRepository.save(new AnswerOption("Oxygen, water, and fuel", false, fireQuestion10));
        AnswerOption answerOption31 = this.answerOptionRepository.save(new AnswerOption("Fuel, ignition, and oxygen", true, fireQuestion10));
        AnswerOption answerOption32 = this.answerOptionRepository.save(new AnswerOption("Fuel, carbon dioxide, and time", false, fireQuestion10));
        AnswerOption answerOption33 = this.answerOptionRepository.save(new AnswerOption("Ignition, carbon dioxide, and moisture", false, fireQuestion10));

        Question fireQuestion11 = this.questionRepository.save(new Question("PEEP stands for:",fireCourse));
        AnswerOption answerOption34 = this.answerOptionRepository.save(new AnswerOption("Personal Evacuation Exit Point", false, fireQuestion11));
        AnswerOption answerOption35 = this.answerOptionRepository.save(new AnswerOption("Prevention Evaluation Evacuation Precaution", false, fireQuestion11));
        AnswerOption answerOption36 = this.answerOptionRepository.save(new AnswerOption("Personal Emergency Evacuation Plan", true, fireQuestion11));
        AnswerOption answerOption37 = this.answerOptionRepository.save(new AnswerOption("Private Evacuation Exit Point", false, fireQuestion11));

        Question fireQuestion12 = this.questionRepository.save(new Question("When you discover a fire, you should…",fireCourse));
        AnswerOption answerOption40 = this.answerOptionRepository.save(new AnswerOption("Pull the fire alarm and call the fire department ", true, fireQuestion12));
        AnswerOption answerOption41 = this.answerOptionRepository.save(new AnswerOption("Use a fire extinguisher to put out the fire, even if you’ve never used a fire extinguisher before", false, fireQuestion12));
        AnswerOption answerOption42 = this.answerOptionRepository.save(new AnswerOption("Stay in the building until you figure out a way to extinguish the fire", false, fireQuestion12));
        AnswerOption answerOption43 = this.answerOptionRepository.save(new AnswerOption("Run out of the building without warning others of the fire", false, fireQuestion12));

        Course EarthCourse = courseRepository.save(new Course("Earthquake"));

        Question earthQuestion2 = this.questionRepository.save(new Question("You are in a house on one floor, when an earthquake suddenly starts. What should you do? ", EarthCourse));
        AnswerOption answerOption4 = this.answerOptionRepository.save(new AnswerOption("Stay in the house and take shelter", false, earthQuestion2));
        AnswerOption answerOption44 = this.answerOptionRepository.save(new AnswerOption("Stay in your bedroom", false, earthQuestion2));
        AnswerOption answerOption5 = this.answerOptionRepository.save(new AnswerOption("Call your loved ones, notify them or write Facebook status", false, earthQuestion2));
        AnswerOption answerOption6 = this.answerOptionRepository.save(new AnswerOption("Stay calm and get out of the house as soon as you can ", true, earthQuestion2));

        Question earthQuestion8 = this.questionRepository.save(new Question("Which of the following can be triggered by an earthquake?", EarthCourse));
        AnswerOption answerOption222 = this.answerOptionRepository.save(new AnswerOption("Tsunami", false, earthQuestion8));
        AnswerOption answerOption23 = this.answerOptionRepository.save(new AnswerOption("Intense ground shaking", false, earthQuestion8));
        AnswerOption answerOption24 = this.answerOptionRepository.save(new AnswerOption("A landslide", false, earthQuestion8));
        AnswerOption answerOption25 = this.answerOptionRepository.save(new AnswerOption("All of these", true, earthQuestion8));

        Question earthQuestion3 = this.questionRepository.save(new Question("You are in a building when an earthquake suddenly starts. What should you do? ", EarthCourse));
        AnswerOption answerOption7 = this.answerOptionRepository.save(new AnswerOption("As soon as you feel it go down the stairs or elevator and leave the building", false, earthQuestion3));
        AnswerOption answerOption8 = this.answerOptionRepository.save(new AnswerOption("Stay calm, take shelter while it lasts and wait for it to stop so you can slowly leave the building ", true, earthQuestion3));
        AnswerOption answerOption9 = this.answerOptionRepository.save(new AnswerOption("Hug your loved ones and sit hidden somewhere in the house  ", false, earthQuestion3));
        AnswerOption answerOption91 = this.answerOptionRepository.save(new AnswerOption("Sit hidden and start screaming", false, earthQuestion3));

        Question earthQuestion9 = this.questionRepository.save(new Question("Which of the following statements is false?", EarthCourse));
        AnswerOption answerOption26 = this.answerOptionRepository.save(new AnswerOption("Most earthquakes occur at plate boundaries", false, earthQuestion9));
        AnswerOption answerOption27 = this.answerOptionRepository.save(new AnswerOption("The time and location of most major earthquakes can be predicted several days in advance", true, earthQuestion9));
        AnswerOption answerOption28 = this.answerOptionRepository.save(new AnswerOption("Earthquakes can be caused by normal, reverse and strike-slip faulting", false, earthQuestion9));
        AnswerOption answerOption29 = this.answerOptionRepository.save(new AnswerOption("P waves travel faster than both S waves and Surface waves", false, earthQuestion9));


        Course floodCourse = courseRepository.save(new Course("Flood"));

        Question floodQuestion4 = this.questionRepository.save(new Question("Imagine that you are on the beach and suddenly you see that the water from the ocean begins to recede sharply. What should you do?", floodCourse));
        AnswerOption answerOption10 = this.answerOptionRepository.save(new AnswerOption("Get in the water and see what happens", false, floodQuestion4));
        AnswerOption answerOption11 = this.answerOptionRepository.save(new AnswerOption("Stay on the beach and observe the situation and the movement of water", false, floodQuestion4));
        AnswerOption answerOption12 = this.answerOptionRepository.save(new AnswerOption("Move away as fast as possible and climb to the highest place", true, floodQuestion4));
        AnswerOption answerOption121 = this.answerOptionRepository.save(new AnswerOption("Move away as fast as possible in unknown direction", false, floodQuestion4));

        Question floodQuestion5 = this.questionRepository.save(new Question("Imagine that while driving a car, the vehicle loses control and falls into a lake. The car starts to sink and you do not have much time to save yourself, what should you do?", floodCourse));
        AnswerOption answerOption13 = this.answerOptionRepository.save(new AnswerOption("Try to start the car and move the vehicle to the surface", false, floodQuestion5));
        AnswerOption answerOption14 = this.answerOptionRepository.save(new AnswerOption("Break the window with a piece of clothing and go out", true, floodQuestion5));
        AnswerOption answerOption15 = this.answerOptionRepository.save(new AnswerOption("To play until someone hears and comes to your rescue", false, floodQuestion5));
        AnswerOption answerOption151 = this.answerOptionRepository.save(new AnswerOption("Stay quiet and wait for rescue", false, floodQuestion5));

        Question floodQuestion6 = this.questionRepository.save(new Question("He is driving a car on the road and it starts to rain heavily and hail. What should be done?", floodCourse));
        AnswerOption answerOption16 = this.answerOptionRepository.save(new AnswerOption("Focus on the road as much as possible and try to reach the destination as quickly as possible", false, floodQuestion6));
        AnswerOption answerOption161 = this.answerOptionRepository.save(new AnswerOption("Try to reach the destination as quickly as possible", false, floodQuestion6));
        AnswerOption answerOption17 = this.answerOptionRepository.save(new AnswerOption("Turn on your flashing lights, seek shelter and wait for it to pass", true, floodQuestion6));
        AnswerOption answerOption18 = this.answerOptionRepository.save(new AnswerOption("Turn on your flashing lights and keep driving slowly to avoid an accident", false, floodQuestion6));


        Question floodQuestion7 = this.questionRepository.save(new Question("Which is not a characteristic of a regional flood?",  floodCourse));
        AnswerOption answerOption19 = this.answerOptionRepository.save(new AnswerOption("An extended rise of river elevation for weeks to months", false, floodQuestion7));
        AnswerOption answerOption20 = this.answerOptionRepository.save(new AnswerOption("Large storm systems or an extended period of rainfall", false, floodQuestion7));
        AnswerOption answerOption21 = this.answerOptionRepository.save(new AnswerOption("A small drainage basin", true, floodQuestion7));
        AnswerOption answerOption22 = this.answerOptionRepository.save(new AnswerOption("Floodplains covered with floodwaters", false,floodQuestion7));


        User user = this.userService.register("username", "password", "password", "user", "user", Role.ROLE_USER, "Macedonia");
        Answer answerflood=answerRepository.save(new Answer(user, answerOption21));
        Answer answerflood1=answerRepository.save(new Answer(user, answerOption31));
        Answer answerflood2=answerRepository.save(new Answer(user, answerOption1));
        Answer answerflood3=answerRepository.save(new Answer(user, answerOption36));
        Answer answerflood4=answerRepository.save(new Answer(user, answerOption17));
        System.out.println(successService.calculateTotalSuccess(user.getUsername())+"total");
        System.out.println(successService.calculateFloodTestSuccess(user.getUsername())+"flood");
        System.out.println(successService.calculateFireTestSuccess(user.getUsername())+"fire");
        System.out.println(successService.calculateEarthquakeTestSuccess(user.getUsername())+"earthquake");
    }
}
