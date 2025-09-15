package np.com.krishnabk.cruddemo.dao;

import np.com.krishnabk.cruddemo.entity.Instructor;
import np.com.krishnabk.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
}
