package np.com.krishnabk.mycoolapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose "/hello" endpoint that returns "Hello World!"

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!!";
    }

    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 5k!";
    }

    // Expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }
}
