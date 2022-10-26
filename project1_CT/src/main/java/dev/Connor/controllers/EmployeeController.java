package dev.Connor.controllers;

import com.google.gson.Gson;
import dev.Connor.driver.Driver;
import dev.Connor.entities.Employee;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//this can replace having all the handler classes
public class EmployeeController {

    private Map<Integer, Employee> employeeTable = new HashMap();

    public Handler createEmployeeHandler = (ctx) ->{
        String json = ctx.body();
        Gson gson = new Gson();
        // fromJson this is taking something from Json to Java
        Employee employee = gson.fromJson(json, Employee.class);
        Employee registeredEmployee = Driver.employeeService.createEmployee(employee);
        // turning the employee back into json
        String employeeJson = gson.toJson(registeredEmployee);
        ctx.status(201);
        ctx.result(employeeJson);
    };
    public Handler getAllEmployee = (ctx) -> {
        // WIP
        // int id = Integer.parseInt(ctx.pathParam("id"));
        List<Employee> employeeList = Driver.employeeService.getAllEmployees();
        // new ArrayList<Employee>(employeeTable.values());
        // Employee employee = Driver.employeeService.getAllEmployees();
        Gson gson = new Gson();
        String json = gson.toJson(employeeList);
        ctx.result(json);
    };
    public Handler getEmployeeByIdHandler = (ctx) ->{
        // this takes the path{id} and turns it into an int for use
        int id = Integer.parseInt(ctx.pathParam("id"));
        Employee employee = Driver.employeeService.getEmployeeID(id);
        Gson gson = new Gson(); //Gson derillo
        String json = gson.toJson(employee);
        ctx.result(json);
    };
    public Handler deleteEmployeeHandler = (ctx) ->{
        int id = Integer.parseInt((ctx.pathParam("id")));
        boolean result = Driver.employeeService.deleteEmployeeById(id);
        if (result){
            ctx.status(204);
        } else {
            ctx.status(400);
            ctx.result("Could not process the delete request");
        }
    };
    public Handler updateEmployeeHandler = (ctx) ->{
        String employeeJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJSON, Employee.class);
        Employee updatedEmployee = Driver.employeeService.updatedEmployee(employee);
        String json = gson.toJson(updatedEmployee);
        ctx.result(json);
    };

}
