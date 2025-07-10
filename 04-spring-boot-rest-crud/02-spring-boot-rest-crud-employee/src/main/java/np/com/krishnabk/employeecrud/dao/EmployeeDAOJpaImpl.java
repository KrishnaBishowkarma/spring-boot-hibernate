package np.com.krishnabk.employeecrud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import np.com.krishnabk.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define fields for entity manager
    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
        public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        // crate query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }
}
