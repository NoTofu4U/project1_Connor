package dev.Connor.services;

import dev.Connor.entities.Employee;
import dev.Connor.repos.EmployeeDAO;
import dev.Connor.repos.EmployeeDAOLocal;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService{
    private EmployeeDAO employeeDAO = new EmployeeDAOLocal();

    // dependency injection (using a class inside of another class
    // look into this later
    // public EmployeeServiceImp(EmployeeDAO employeeDAO){
    //    this.employeeDAO = employeeDAO;
    //}

    @Override
    public Employee createEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee getEmployeeID(int employeeId) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee updatedEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployeeById(int employeeId) {
        return false;
    }
}
