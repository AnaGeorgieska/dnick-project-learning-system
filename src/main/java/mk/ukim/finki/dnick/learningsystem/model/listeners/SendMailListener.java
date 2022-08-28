package mk.ukim.finki.dnick.learningsystem.model.listeners;

import mk.ukim.finki.dnick.learningsystem.model.User;
import mk.ukim.finki.dnick.learningsystem.model.events.SendMailEvent;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.EmailSenderService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.SuccessService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class SendMailListener {
    private final EmailSenderService senderService;
    private final SuccessService successService;

    public SendMailListener(EmailSenderService senderService, SuccessService successService) {
        this.senderService = senderService;
        this.successService = successService;
    }

    @EventListener()
    public void sendMail(SendMailEvent event) throws MessagingException {
        User user = event.user;
        StringBuilder stringBuilder = new StringBuilder();
        String body = stringBuilder
                .append("Name Surname: ").append(user.getName() + " " + user.getSurname()).append("\n")
                .append("You can find attached your certificate. ").append("\n")
                .toString();
        senderService.sendEmail(user.getUsername(),
                "Certificate", body, user, successService.calculateFloodTestSuccess(user.getUsername()),
                successService.calculateFireTestSuccess(user.getUsername()),
                successService.calculateEarthquakeTestSuccess(user.getUsername()),
                successService.calculateTotalSuccess(user.getUsername())
                );
    }
}
