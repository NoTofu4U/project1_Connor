package dev.Connor.repos;

import dev.Connor.entities.Employee;
import dev.Connor.util.ConnectionFactory;

import java.sql.*;
import java.util.List;

public class EmployeeDAOPostgres implements EmployeeDAO{
    @Override
    public Employee createEmployee(Employee employee) {
        try(Connection conn = ConnectionFactory.getConnection()) {
            String sql = "insert into books values(default, ?, ?, ?, ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getUsername());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setBoolean(4, employee.getManager());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys(); //generatedkeys pulls the keys we told it to
            resultSet.next();
            int generatedKey = resultSet.getInt("employeeid"); // this may need to match dBeaver or Employee.java
            employee.setEmployeeId(generatedKey);

            return employee;

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeID(int employeeId) {
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "select * from employees where employeeid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employeeid"));
            employee.setName(rs.getString("emName"));
            employee.setUsername(rs.getString("emUsername"));
            employee.setPassword(rs.getString("emPassword"));
            employee.setManager(rs.getBoolean("emIsManager"));

            return employee;
        } catch(SQLException e){
            e.printStackTrace();
        }

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
