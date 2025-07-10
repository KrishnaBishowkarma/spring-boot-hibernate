package np.com.krishnabk.employeecrud.dao;

import np.com.krishnabk.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
