package np.com.krishnabk.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose "/hello" endpoint that return "Hello World"
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
