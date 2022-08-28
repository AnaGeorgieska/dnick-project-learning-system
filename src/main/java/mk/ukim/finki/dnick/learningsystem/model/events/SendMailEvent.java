package mk.ukim.finki.dnick.learningsystem.model.events;

import lombok.Getter;
import mk.ukim.finki.dnick.learningsystem.model.User;
import org.springframework.context.ApplicationEvent;

@Getter
public class SendMailEvent extends ApplicationEvent {

    public User user;

    public SendMailEvent(User user) {
        super(user);
        this.user=user;
    }
}