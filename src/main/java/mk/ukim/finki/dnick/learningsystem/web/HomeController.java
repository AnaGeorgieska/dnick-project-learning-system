package mk.ukim.finki.dnick.learningsystem.web;

import mk.ukim.finki.dnick.learningsystem.model.User;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getHomePage(HttpServletRequest request) {
        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
        }
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
