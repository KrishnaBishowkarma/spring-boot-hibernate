package np.com.krishnabk.employeecrud.rest;

import np.com.krishnabk.employeecrud.dao.EmployeeDAO;
import np.com.krishnabk.employeecrud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // quick and dirty : inject employee dao use constructor injection (will add service layer later)
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
