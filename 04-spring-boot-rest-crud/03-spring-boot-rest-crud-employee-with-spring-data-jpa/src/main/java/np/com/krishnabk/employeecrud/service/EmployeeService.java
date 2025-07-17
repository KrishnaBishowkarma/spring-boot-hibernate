package np.com.krishnabk.employeecrud.service;

import np.com.krishnabk.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
