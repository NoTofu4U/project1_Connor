package dev.Connor.services;

import dev.Connor.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeID(int employeeId);

    List<Employee> getAllEmployees();

    Employee updatedEmployee(Employee employee);

    boolean deleteEmployeeById(int employeeId);


}
