package dev.Connor.services;

import dev.Connor.entities.Employee;
import dev.Connor.exceptions.InvalidUsernameException;
import dev.Connor.repos.EmployeeDAO;
import dev.Connor.repos.EmployeeDAOLocal;

import java.util.ArrayList;
import java.util.List;

// business logic is done here

public class EmployeeServiceImp implements EmployeeService{
    private EmployeeDAO employeeDAO;
    private List<Employee> employeeList = new ArrayList<>();

     public EmployeeServiceImp(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee createEmployee(Employee employee) {
         if(employee.getUsername().length() == 0){
             throw new InvalidUsernameException("Employee must have a username");
             //throw new RuntimeException("Employee must have a username");
         }
         if(employee.getPassword().length() == 0){
             throw new RuntimeException("Employee needs a password");
         } // these need to be created for every variable that must have a field to validate it
         Employee savedEmployee = this.employeeDAO.createEmployee(employee);
         //this is getting the created list into Javalin list
         return savedEmployee;
    }

    @Override
    public Employee getEmployeeID(int employeeId) {
        // just passing information along
        return this.employeeDAO.getEmployeeID(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {

         return this.employeeDAO.getAllEmployees();
    }

    @Override
    public Employee updatedEmployee(Employee employee) {
        if(employee.getUsername().length() == 0){
            throw new RuntimeException("Employee must have a username");
        }
        if(employee.getPassword().length() == 0){
            throw new RuntimeException("Employee needs a password");
        }
        return this.employeeDAO.updatedEmployee(employee);
    }

    @Override
    public boolean deleteEmployeeById(int employeeId) {

         return this.employeeDAO.deleteEmployeeById(employeeId);
    }
}
