package dev.Connor.repos;

import dev.Connor.entities.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAOLocal implements EmployeeDAO{

    private Map<Integer, Employee> employeeTable = new HashMap();
    private int idCount = 1;

    @Override // these have to be Overriden bc it's from an interface bc this class isn't abstract
    public Employee createEmployee(Employee employee) {
        employee.setEmployeeId(idCount);
        idCount++;
        employeeTable.put(employee.getEmployeeId(), employee);
        System.out.println(employeeTable.values());
        return employee;
    }

    @Override
    public Employee getEmployeeID(int employeeId) {
        return employeeTable.get(employeeId);
    }

    @Override // this should return everything from the DB
    public List<Employee> getAllEmployees() {

        return null;
    }

    @Override
    public Employee updatedEmployee(Employee employee) {
        return employeeTable.put(employee.getEmployeeId(), employee);
    }

    @Override
    public boolean deleteEmployeeById(int employeeId) {
        Employee employee = employeeTable.remove(employeeId); // returns the employee obj that was removed
        if (employee == null){
            return false;
        } else {
            return true;
        }
    }
}
