package np.com.krishnabk.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = {"np.com.krishnabk.springcoredemo",
                        "np.com.krishnabk.util"
    })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
