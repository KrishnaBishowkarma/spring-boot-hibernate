package np.com.krishnabk.cruddemo;

import np.com.krishnabk.cruddemo.dao.StudentDAO;
import np.com.krishnabk.cruddemo.intity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
//              createStudent(studentDAO);

//              createMultipleStudents(studentDAO);

//              readStudent(studentDAO);

//              queryForStudents(studentDAO);

//              queryForStudentsByLastName(studentDAO);

              updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on the id: Primary Key
        int studentId = 2;
        System.out.println("Getting student with studentId: " + studentId);
        Student theStudent = studentDAO.findById(studentId);

        // change first name to "Ram"
        System.out.println("Updating student ...");
        theStudent.setFirstName("Ram");

        // update the student
        studentDAO.update(theStudent);

        // display the updated student
        System.out.println("Updated student: " + theStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student>theStudents =studentDAO.findByLastName("BK");

        // display list of students
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Hary", "BK", "hary@gmail.com");


        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated ID: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 studen objects ...");
        Student tempStudent1 = new Student("Hari", "Shankar", "hari@gmail.com");
        Student tempStudent2 = new Student("Krishna", "BK", "krishna@gmail.com");
        Student tempStudent3 = new Student("Naresh", "BK", "naresh@gmail.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("John", "Saud", "john@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated ID: " + tempStudent.getId());
    }

}
