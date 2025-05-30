package np.com.krishnabk.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TennisCoach.class);

    public TennisCoach(){
        logger.info("In Constructor: {}", getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
