package np.com.krishnabk.springcoredemo;

public class FootBallCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run for 15 minutes.";
    }
}
