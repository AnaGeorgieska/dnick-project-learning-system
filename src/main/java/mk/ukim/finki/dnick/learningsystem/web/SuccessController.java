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
@RequestMapping("/success")
public class SuccessController {
    private final UserService userService;
    private final SuccessService successService;

    public SuccessController(UserService userService, SuccessService successService) {
        this.userService = userService;
        this.successService = successService;
    }

    @GetMapping("/flood")
    public String getSuccessFloodPage(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            model.addAttribute("success", successService.calculateFloodTestSuccess(username));
        }
        return "success";
    }
    @GetMapping("/fire")
    public String getSuccessFirePage(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            model.addAttribute("success", successService.calculateFireTestSuccess(username));
        }
        return "success";
    }
    @GetMapping("/earthquake")
    public String getSuccessEarthPage(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        if(username!=null)
        {
            User user = userService.findById(username);
            System.out.println(user.toString());
            model.addAttribute("success", successService.calculateEarthquakeTestSuccess(username));
        }
        return "success";
    }
}
