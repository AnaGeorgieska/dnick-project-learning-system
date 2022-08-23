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

        AnswerOption answerOption111 = this.answerOptionRepository.save(new AnswerOption("Hurry up and get out of the house as soon as possible", false));
        AnswerOption answerOption1 = this.answerOptionRepository.save(new AnswerOption("Hurry up to collect all the valuable items from the house that you do not want to burn", false));
        AnswerOption answerOption2 = this.answerOptionRepository.save(new AnswerOption("Try to put out the fire in every possible way", false));
        AnswerOption answerOption3 = this.answerOptionRepository.save(new AnswerOption("Cover your mouth and nose with a cloth and get out of the house as soon as possible", true));
        List<AnswerOption> answerOptionList = new ArrayList<>();
        answerOptionList.add(answerOption1);
        answerOptionList.add(answerOption111);
        answerOptionList.add(answerOption2);
        answerOptionList.add(answerOption3);
        Question fireQuestion = this.questionRepository.save(new Question("A fire suddenly breaks out in the home. Before calling the fire department, you should ... ", answerOptionList,fireCourse));

        AnswerOption answerOption30 = this.answerOptionRepository.save(new AnswerOption("Oxygen, water, and fuel", false));
        AnswerOption answerOption31 = this.answerOptionRepository.save(new AnswerOption("Fuel, ignition, and oxygen", true));
        AnswerOption answerOption32 = this.answerOptionRepository.save(new AnswerOption("Fuel, carbon dioxide, and time", false));
        AnswerOption answerOption33 = this.answerOptionRepository.save(new AnswerOption("Ignition, carbon dioxide, and moisture", false));
        List<AnswerOption> answerOptionList10 = new ArrayList<>();
        answerOptionList10.add(answerOption30);
        answerOptionList10.add(answerOption31);
        answerOptionList10.add(answerOption32);
        answerOptionList10.add(answerOption33);
        Question fireQuestion10 = this.questionRepository.save(new Question("Which three components are needed to start a fire?", answerOptionList10,fireCourse));

        AnswerOption answerOption34 = this.answerOptionRepository.save(new AnswerOption("Personal Evacuation Exit Point", false));
        AnswerOption answerOption35 = this.answerOptionRepository.save(new AnswerOption("Prevention Evaluation Evacuation Precaution", false));
        AnswerOption answerOption36 = this.answerOptionRepository.save(new AnswerOption("Personal Emergency Evacuation Plan", true));
        AnswerOption answerOption37 = this.answerOptionRepository.save(new AnswerOption("Private Evacuation Exit Point", false));
        List<AnswerOption> answerOptionList11 = new ArrayList<>();
        answerOptionList11.add(answerOption34);
        answerOptionList11.add(answerOption35);
        answerOptionList11.add(answerOption36);
        answerOptionList11.add(answerOption37);
        Question fireQuestion11 = this.questionRepository.save(new Question("PEEP stands for:", answerOptionList11,fireCourse));

        AnswerOption answerOption40 = this.answerOptionRepository.save(new AnswerOption("Pull the fire alarm and call the fire department ", true));
        AnswerOption answerOption41 = this.answerOptionRepository.save(new AnswerOption("Use a fire extinguisher to put out the fire, even if you’ve never used a fire extinguisher before", false));
        AnswerOption answerOption42 = this.answerOptionRepository.save(new AnswerOption("Stay in the building until you figure out a way to extinguish the fire", false));
        AnswerOption answerOption43 = this.answerOptionRepository.save(new AnswerOption("Run out of the building without warning others of the fire", false));
        List<AnswerOption> answerOptionList12 = new ArrayList<>();
        answerOptionList12.add(answerOption40);
        answerOptionList12.add(answerOption41);
        answerOptionList12.add(answerOption42);
        answerOptionList12.add(answerOption43);
        Question fireQuestion12 = this.questionRepository.save(new Question("When you discover a fire, you should…", answerOptionList12,fireCourse));

        Course EarthCourse = courseRepository.save(new Course("Earthquake"));

        AnswerOption answerOption4 = this.answerOptionRepository.save(new AnswerOption("Stay in the house and take shelter", false));
        AnswerOption answerOption44 = this.answerOptionRepository.save(new AnswerOption("Stay in your bedroom", false));
        AnswerOption answerOption5 = this.answerOptionRepository.save(new AnswerOption("Call your loved ones, notify them or write Facebook status", false));
        AnswerOption answerOption6 = this.answerOptionRepository.save(new AnswerOption("Stay calm and get out of the house as soon as you can ", true));
        List<AnswerOption> answerOptionList2 = new ArrayList<>();
        answerOptionList2.add(answerOption4);
        answerOptionList2.add(answerOption44);
        answerOptionList2.add(answerOption5);
        answerOptionList2.add(answerOption6);
        Question earthQuestion2 = this.questionRepository.save(new Question("You are in a house on one floor, when an earthquake suddenly starts. What should you do? ", answerOptionList2, EarthCourse));

        AnswerOption answerOption222 = this.answerOptionRepository.save(new AnswerOption("Tsunami", false));
        AnswerOption answerOption23 = this.answerOptionRepository.save(new AnswerOption("Intense ground shaking", false));
        AnswerOption answerOption24 = this.answerOptionRepository.save(new AnswerOption("A landslide", false));
        AnswerOption answerOption25 = this.answerOptionRepository.save(new AnswerOption("All of these", true));
        List<AnswerOption> answerOptionList8 = new ArrayList<>();
        answerOptionList8.add(answerOption222);
        answerOptionList8.add(answerOption23);
        answerOptionList8.add(answerOption24);
        answerOptionList8.add(answerOption25);
        Question earthQuestion8 = this.questionRepository.save(new Question("Which of the following can be triggered by an earthquake?", answerOptionList8, EarthCourse));

        AnswerOption answerOption7 = this.answerOptionRepository.save(new AnswerOption("As soon as you feel it go down the stairs or elevator and leave the building", false));
        AnswerOption answerOption8 = this.answerOptionRepository.save(new AnswerOption("Stay calm, take shelter while it lasts and wait for it to stop so you can slowly leave the building ", true));
        AnswerOption answerOption9 = this.answerOptionRepository.save(new AnswerOption("Hug your loved ones and sit hidden somewhere in the house  ", false));
        AnswerOption answerOption91 = this.answerOptionRepository.save(new AnswerOption("Sit hidden and start screaming", false));
        List<AnswerOption> answerOptionList3 = new ArrayList<>();
        answerOptionList3.add(answerOption7);
        answerOptionList3.add(answerOption8);
        answerOptionList3.add(answerOption9);
        answerOptionList3.add(answerOption91);
        Question earthQuestion3 = this.questionRepository.save(new Question("You are in a building when an earthquake suddenly starts. What should you do? ", answerOptionList3, EarthCourse));

        AnswerOption answerOption26 = this.answerOptionRepository.save(new AnswerOption("Most earthquakes occur at plate boundaries", false));
        AnswerOption answerOption27 = this.answerOptionRepository.save(new AnswerOption("The time and location of most major earthquakes can be predicted several days in advance", true));
        AnswerOption answerOption28 = this.answerOptionRepository.save(new AnswerOption("Earthquakes can be caused by normal, reverse and strike-slip faulting", false));
        AnswerOption answerOption29 = this.answerOptionRepository.save(new AnswerOption("P waves travel faster than both S waves and Surface waves", false));
        List<AnswerOption> answerOptionList9 = new ArrayList<>();
        answerOptionList9.add(answerOption26);
        answerOptionList9.add(answerOption27);
        answerOptionList9.add(answerOption28);
        answerOptionList9.add(answerOption29);
        Question earthQuestion9 = this.questionRepository.save(new Question("Which of the following statements is false?", answerOptionList9, EarthCourse));


        Course floodCourse = courseRepository.save(new Course("Flood"));

        AnswerOption answerOption10 = this.answerOptionRepository.save(new AnswerOption("Get in the water and see what happens", false));
        AnswerOption answerOption11 = this.answerOptionRepository.save(new AnswerOption("Stay on the beach and observe the situation and the movement of water", false));
        AnswerOption answerOption12 = this.answerOptionRepository.save(new AnswerOption("Move away as fast as possible and climb to the highest place", true));
        AnswerOption answerOption121 = this.answerOptionRepository.save(new AnswerOption("Move away as fast as possible in unknown direction", false));
        List<AnswerOption> answerOptionList4 = new ArrayList<>();
        answerOptionList4.add(answerOption10);
        answerOptionList4.add(answerOption11);
        answerOptionList4.add(answerOption12);
        answerOptionList4.add(answerOption121);
        Question floodQuestion4 = this.questionRepository.save(new Question("Imagine that you are on the beach and suddenly you see that the water from the ocean begins to recede sharply. What should you do?", answerOptionList4, floodCourse));

        AnswerOption answerOption13 = this.answerOptionRepository.save(new AnswerOption("Try to start the car and move the vehicle to the surface", false));
        AnswerOption answerOption14 = this.answerOptionRepository.save(new AnswerOption("Break the window with a piece of clothing and go out", true));
        AnswerOption answerOption15 = this.answerOptionRepository.save(new AnswerOption("To play until someone hears and comes to your rescue", false));
        AnswerOption answerOption151 = this.answerOptionRepository.save(new AnswerOption("Stay quiet and wait for rescue", false));
        List<AnswerOption> answerOptionList5 = new ArrayList<>();
        answerOptionList5.add(answerOption13);
        answerOptionList5.add(answerOption14);
        answerOptionList5.add(answerOption15);
        answerOptionList5.add(answerOption151);
        Question floodQuestion5 = this.questionRepository.save(new Question("Imagine that while driving a car, the vehicle loses control and falls into a lake. The car starts to sink and you do not have much time to save yourself, what should you do?", answerOptionList5, floodCourse));

        AnswerOption answerOption16 = this.answerOptionRepository.save(new AnswerOption("Focus on the road as much as possible and try to reach the destination as quickly as possible", false));
        AnswerOption answerOption161 = this.answerOptionRepository.save(new AnswerOption("Try to reach the destination as quickly as possible", false));
        AnswerOption answerOption17 = this.answerOptionRepository.save(new AnswerOption("Turn on your flashing lights, seek shelter and wait for it to pass", true));
        AnswerOption answerOption18 = this.answerOptionRepository.save(new AnswerOption("Turn on your flashing lights and keep driving slowly to avoid an accident", false));
        List<AnswerOption> answerOptionList6 = new ArrayList<>();
        answerOptionList6.add(answerOption161);
        answerOptionList6.add(answerOption16);
        answerOptionList6.add(answerOption17);
        answerOptionList6.add(answerOption18);
        Question floodQuestion6 = this.questionRepository.save(new Question("He is driving a car on the road and it starts to rain heavily and hail. What should be done?", answerOptionList6, floodCourse));

        AnswerOption answerOption19 = this.answerOptionRepository.save(new AnswerOption("An extended rise of river elevation for weeks to months", false));
        AnswerOption answerOption20 = this.answerOptionRepository.save(new AnswerOption("Large storm systems or an extended period of rainfall", false));
        AnswerOption answerOption21 = this.answerOptionRepository.save(new AnswerOption("A small drainage basin", true));
        AnswerOption answerOption22 = this.answerOptionRepository.save(new AnswerOption("Floodplains covered with floodwaters", false));
        List<AnswerOption> answerOptionList7 = new ArrayList<>();
        answerOptionList7.add(answerOption19);
        answerOptionList7.add(answerOption20);
        answerOptionList7.add(answerOption21);
        answerOptionList7.add(answerOption22);
        Question floodQuestion7 = this.questionRepository.save(new Question("Which is not a characteristic of a regional flood?", answerOptionList7, floodCourse));

    }
}
