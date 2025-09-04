package np.com.krishnabk.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showForm() {

        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaders() {

        return "leaders";
    }

    // add mapping for /systems
    @GetMapping("/systems")
    public String showSystems() {

        return "systems";
    }
}
