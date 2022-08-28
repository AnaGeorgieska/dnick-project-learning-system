package mk.ukim.finki.dnick.learningsystem.web;

import mk.ukim.finki.dnick.learningsystem.model.User;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.SuccessService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {
    private final UserService userService;
    private final SuccessService successService;

    public HomeController(UserService userService, SuccessService successService) {
        this.userService = userService;
        this.successService = successService;
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
    public String getUserPage(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            model.addAttribute("floodSuccess", successService.calculateFloodTestSuccess(username));
            model.addAttribute("fireSuccess", successService.calculateFireTestSuccess(username));
            model.addAttribute("earthquakeSuccess", successService.calculateEarthquakeTestSuccess(username));
            model.addAttribute("success", successService.calculateTotalSuccess(username));
        }
        return "user";
    }

    @GetMapping("/help")
    public String getHelpPage() {
        return "help";
    }
}
