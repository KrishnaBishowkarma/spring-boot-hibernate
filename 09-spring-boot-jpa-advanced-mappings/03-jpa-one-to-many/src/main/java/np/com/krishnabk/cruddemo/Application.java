package np.com.krishnabk.cruddemo;

import np.com.krishnabk.cruddemo.dao.AppDAO;
import np.com.krishnabk.cruddemo.entity.Course;
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
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
//            deleteInstructorDetail(appDAO);
            createInstructorWithCourses(appDAO);
        };
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Naresh", "Lohar", "naresh@krishna-bk.com.np");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail("https://www.youtube.com", "Music");

        // create the courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("Basic of MUSIC");
        Course tempCourse3 = new Course("The Pinball Masterclass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);
        tempInstructor.add(tempCourse3);

        // save the instructor
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);
        System.out.println("DONE!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {

        int theId = 3;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");

    }

    private void findInstructorDetail(AppDAO appDAO) {

        // get the instructor detail object
        int theId = 1;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor detail
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        // print the associated instructor
        System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding Instructor id: " + theId);

        Instructor tempInstructor  = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        if (tempInstructor != null) {
            System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
        } else {
            System.out.println("Instructor not found with id: " + theId);
        }
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
