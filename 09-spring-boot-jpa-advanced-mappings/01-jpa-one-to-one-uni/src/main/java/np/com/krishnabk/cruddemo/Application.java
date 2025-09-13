package np.com.krishnabk.cruddemo;

import np.com.krishnabk.cruddemo.dao.AppDAO;
import np.com.krishnabk.cruddemo.entity.Instructor;
import np.com.krishnabk.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){

        return runner -> {
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor = new Instructor(
                "Krishna", "Bishowkarma", "hi@krishna-bk.com.np"
        );

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "https://www.youtube.com/@krishnabkarma","Filmmaking"
        );

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the objects
        // NOTE: this will also save the details object because of CascadeType.ALL
        System.out.println("Saving Instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }

}
