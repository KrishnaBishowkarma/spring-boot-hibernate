package np.com.krishnabk.cruddemo.dao;

import np.com.krishnabk.cruddemo.intity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
