package mk.ukim.finki.dnick.learningsystem;

import mk.ukim.finki.dnick.learningsystem.service.interfaces.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.MessagingException;

@SpringBootApplication
public class LearningSystemApplication {
    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(LearningSystemApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail() throws MessagingException {
//        senderService.sendEmail("anageorgieska@gmail.com",
//                "Sample Subject", "This is the body of the email");
//
//    }

}
