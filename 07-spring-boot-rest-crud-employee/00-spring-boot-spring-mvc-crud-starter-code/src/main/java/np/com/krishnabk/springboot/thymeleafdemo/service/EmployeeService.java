package np.com.krishnabk.springboot.thymeleafdemo.service;

import np.com.krishnabk.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
