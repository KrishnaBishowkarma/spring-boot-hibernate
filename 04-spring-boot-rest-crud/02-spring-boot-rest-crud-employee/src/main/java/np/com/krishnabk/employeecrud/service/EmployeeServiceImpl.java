package np.com.krishnabk.employeecrud.service;

import np.com.krishnabk.employeecrud.dao.EmployeeDAO;
import np.com.krishnabk.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // define field
    private EmployeeDAO employeeDAO;

    // constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
