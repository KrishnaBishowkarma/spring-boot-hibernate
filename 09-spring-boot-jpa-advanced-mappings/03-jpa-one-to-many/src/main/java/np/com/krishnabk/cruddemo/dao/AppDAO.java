package np.com.krishnabk.cruddemo.dao;

import np.com.krishnabk.cruddemo.entity.Course;
import np.com.krishnabk.cruddemo.entity.Instructor;
import np.com.krishnabk.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructor(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);
}
