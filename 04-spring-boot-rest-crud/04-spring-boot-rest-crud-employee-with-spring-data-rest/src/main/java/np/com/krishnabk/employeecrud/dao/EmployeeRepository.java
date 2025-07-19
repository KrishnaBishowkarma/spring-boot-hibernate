package np.com.krishnabk.employeecrud.dao;

import np.com.krishnabk.employeecrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it ... no need to write any code LOL!
}
