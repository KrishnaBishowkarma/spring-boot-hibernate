package np.com.krishnabk.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run for 15 minutes.";
    }
}
