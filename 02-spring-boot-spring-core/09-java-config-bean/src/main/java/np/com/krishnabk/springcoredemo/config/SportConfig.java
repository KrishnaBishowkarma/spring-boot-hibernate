package np.com.krishnabk.springcoredemo.config;

import np.com.krishnabk.springcoredemo.common.Coach;
import np.com.krishnabk.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
