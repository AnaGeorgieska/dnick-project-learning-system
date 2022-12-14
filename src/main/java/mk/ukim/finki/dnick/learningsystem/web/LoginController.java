package mk.ukim.finki.dnick.learningsystem.web;

import mk.ukim.finki.dnick.learningsystem.model.User;
import mk.ukim.finki.dnick.learningsystem.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        User user = null;
        try{
            user = this.authService.login(username,
                    password);
//            request.getSession().setAttribute("user", user);
            System.out.println(user.toString()+"login");
            return "redirect:/";
        }
        catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }
}