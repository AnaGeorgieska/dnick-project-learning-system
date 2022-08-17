package mk.ukim.finki.dnick.learningsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHomePage() {
        return "home";
    }
    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }
    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }
    @GetMapping("/help")
    public String getHelpPage() {
        return "help";
    }
}
