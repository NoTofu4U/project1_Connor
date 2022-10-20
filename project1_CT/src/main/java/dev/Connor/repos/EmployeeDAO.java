package dev.Connor.repos;

import dev.Connor.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    // here we can create the framework for other methods if need be(?)
    Employee createEmployee(Employee employee);

    Employee getEmployeeID(int employeeId);

    List<Employee> getAllEmployees();

    Employee updatedEmployee(Employee employee);

    boolean deleteEmployeeById(int employeeId);

}
