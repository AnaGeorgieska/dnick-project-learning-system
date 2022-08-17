package mk.ukim.finki.dnick.learningsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestsController {
    @GetMapping("/fire")
    public String getFirePage() {
        return "fireTest";
    }
    @GetMapping("/flood")
    public String getFloodPage() {
        return "floodTest";
    }
    @GetMapping("/earthquake")
    public String getEarthquakeage() {
        return "earthquakeTest";
    }
}

