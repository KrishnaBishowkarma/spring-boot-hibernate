package np.com.krishnabk.mycoolapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose "/hello" endpoint that returns "Hello World!"

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
