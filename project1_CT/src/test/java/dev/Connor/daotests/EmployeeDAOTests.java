package dev.Connor.daotests;

import dev.Connor.entities.Employee;
import dev.Connor.repos.EmployeeDAO;
import dev.Connor.repos.EmployeeDAOLocal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDAOTests {

    static EmployeeDAO employeeDAO = new EmployeeDAOLocal(); // when we don't need to use the local, we can just change the name

    @Test
    @Order(1)
    void create_employee_test(){
        Employee newEmployee = new Employee(0, "Test", "TestUserName", "TestPassword", false);
        Employee savedEmployee = employeeDAO.createEmployee(newEmployee); // this passes in the above employee
        Assertions.assertNotEquals(0, savedEmployee.getEmployeeId());
    }

    @Test
    @Order(2)
    void get_employee_id_test(){
        Employee retreivedEmployee = employeeDAO.getEmployeeID(1);
        Assertions.assertEquals("Test", retreivedEmployee.getEmployeeId());
    }

    @Test
    @Order(3)
    void update_employee_test(){
        Employee employee = employeeDAO.getEmployeeID(1);
        Employee employeev2 = new Employee(employee.getEmployeeId(), employee.getName(), employee.getUsername(), employee.getPassword(), employee.getManager());
        employeeDAO.updatedEmployee(employeev2);
        Employee updatedEmployee = employeeDAO.getEmployeeID(employeev2.getEmployeeId());
        Assertions.assertEquals("Test", updatedEmployee.getName());
    }

    @Test
    @Order(4)
    void delete_employees_by_id_test(){
        boolean result = employeeDAO.deleteEmployeeById(1);
        Assertions.assertTrue(result);
    }

}
