package dev.Connor.controllers;

import com.google.gson.Gson;
import dev.Connor.driver.Driver;
import dev.Connor.entities.Employee;
import io.javalin.http.Handler;


//this can replace having all the handler classes
public class EmployeeController {


    public Handler createEmployeeHandler = (ctx) ->{
        String json = ctx.body();
        Gson gson = new Gson();
        // fromJson this is taking something from Json to Java
        Employee employee = gson.fromJson(json, Employee.class);
        Employee registeredEmployee = Driver.employeeDAO.createEmployee(employee);
        // turning the employee back into json
        String employeeJson = gson.toJson(registeredEmployee);
        ctx.status(201);
        ctx.result(employeeJson);
    };

    public Handler deleteEmployeeHandler = (ctx) ->{
        int id = Integer.parseInt((ctx.pathParam("id")));
        boolean result = Driver.employeeDAO.deleteEmployeeById(id);
        if (result){
            ctx.status(204);
        } else {
            ctx.status(400);
            ctx.result("Could not process the delete request");
        }
    };

    public Handler getEmployeeByIdHandler = (ctx) ->{
        // this takes the path{id} and turns it into an int for use
        int id = Integer.parseInt(ctx.pathParam("id"));
        Employee employee = Driver.employeeDAO.getEmployeeID(id);
        Gson gson = new Gson(); //Gson derillo
        String json = gson.toJson(employee);
        ctx.result(json);
    };

    public Handler updateEmployeeHandler = (ctx) ->{
        String employeeJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJSON, Employee.class);
        Employee updatedEmployee = Driver.employeeDAO.updatedEmployee(employee);
        String json = gson.toJson(updatedEmployee);
        ctx.result(json);
    };

}
