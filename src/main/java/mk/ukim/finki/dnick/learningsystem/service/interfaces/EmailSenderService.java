package mk.ukim.finki.dnick.learningsystem.service.interfaces;

import mk.ukim.finki.dnick.learningsystem.model.User;

import javax.mail.MessagingException;

public interface EmailSenderService {

    void sendEmail(String toEmail, String subject, String body, User user, double v, double calculateFireTestSuccess, double calculateEarthquakeTestSuccess, double calculateTotalSuccess);

    void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException;

}
