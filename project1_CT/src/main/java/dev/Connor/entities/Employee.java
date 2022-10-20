package dev.Connor.entities;

public class Employee {
    private int employeeId;
    private String name;
    private String username;
    private String password;
    private Boolean isManager = false;

    // no arg constructor
    public Employee() {
    }

    public Employee(int employeeId, String name, String username, String password, Boolean isManager) {
        this.employeeId = employeeId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isManager = isManager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isManager=" + isManager +
                '}';
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }





}
