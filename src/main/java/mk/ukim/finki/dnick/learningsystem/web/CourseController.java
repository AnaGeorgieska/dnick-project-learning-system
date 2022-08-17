package mk.ukim.finki.dnick.learningsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {
    @GetMapping("/fire")
    public String getFirePage() {
        return "fire";
    }
    @GetMapping("/flood")
    public String getFloodPage() {
        return "flood";
    }
    @GetMapping("/earthquake")
    public String getEarthquakeage() {
        return "earthquake";
    }
}
