package np.com.krishnabk.cruddemo;

import np.com.krishnabk.cruddemo.dao.AppDAO;
import np.com.krishnabk.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){

        return runner -> {
            //  createCourseAndStudents(appDAO);
            findCourseAndStudents(appDAO);
        };
    }

    private void findCourseAndStudents(AppDAO appDAO) {

        int theId = 10;

        Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());

        System.out.println("DONE!");

    }

    private void createCourseAndStudents(AppDAO appDAO) {

        // create course
        Course tempCourse = new Course("Happy Path");

        // crete the students
        Student tempStudent1 = new Student("Bipasha", "Kafle", "bipasha@krishna-bk.com.np");
        Student tempStudent2 = new Student("Bibechana", "Kafle", "bibechana@krishna-bk.com.np");

        // add students to the course
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);

        // save the course and associated course
        System.out.println("Saving the course: " + tempCourse);
        System.out.println("associated students: " + tempCourse.getStudents());

        appDAO.save(tempCourse);

        System.out.println("DONE!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int theId = 10;

        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("DONE!");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {

        // get the course and reviews
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);

        // print the course
        System.out.println(tempCourse);

        // print the reviews
        System.out.println(tempCourse.getReviews());

        System.out.println("DONE!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {

        // create a course
        Course tempCourse = new Course("Pacman - How to score One Million Points");

        // add some reviews
        tempCourse.addReview(new Review("Great Course - Loved it!"));
        tempCourse.addReview(new Review("Cool course, job well done."));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        // save the course ... and leverage the cascade all
        System.out.println("Saving the course");
        System.out.println("tempCourse");
        System.out.println(tempCourse.getReviews());


        appDAO.save(tempCourse);

        System.out.println("DONE!");
    }

    private void deleteCourse(AppDAO appDAO) {

        int theId = 10;

        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("DONE!");
    }

    private void updateCourse(AppDAO appDAO) {

        int theId = 10;

        // find the course
        System.out.println("Finding the course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        // update the course
        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("Enjoy the Simple Things");

        appDAO.update(tempCourse);

        System.out.println("DONE!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 2;

        // find the instructor
        System.out.println("Finding instructor: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("B.K");

        appDAO.update(tempInstructor);

        System.out.println("DONE!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 2;

        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("DONE!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {

        int theId = 2;

        System.out.println("Finding Instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructor(theId);

        // associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("The associated courses: " + tempInstructor.getCourses());

        System.out.println("DONE!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Finding Instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("DONE!");
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

        int theId = 2;
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
