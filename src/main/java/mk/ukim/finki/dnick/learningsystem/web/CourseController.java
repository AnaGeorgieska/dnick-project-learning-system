package mk.ukim.finki.dnick.learningsystem.web;

import mk.ukim.finki.dnick.learningsystem.service.interfaces.QuestionService;
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
    @GetMapping("/duringFire")
    public String getDuringFirePage() {
        return "duringFire";
    }
    @GetMapping("/afterFire")
    public String getAfterFirePage() {
        return "afterFire";
    }

    @GetMapping("/flood")
    public String getFloodPage() {
        return "flood";
    }
    @GetMapping("/duringFlood")
    public String getDuringFloodPage() {
        return "duringFlood";
    }
    @GetMapping("/afterFlood")
    public String getAfterFloodPage() {
        return "afterFlood";
    }

    @GetMapping("/earthquake")
    public String getEarthquakeage() {
        return "earthquake";
    }
    @GetMapping("/duringEarthquake")
    public String getDuringEarthquakePage() {
        return "duringEarthquake";
    }
    @GetMapping("/afterEarthquake")
    public String getAfterEarthquakePage() {
        return "afterEarthquake";
    }
}
