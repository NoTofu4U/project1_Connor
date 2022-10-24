package dev.Connor.handlersDefunct;

import com.google.gson.Gson;
import dev.Connor.driver.Driver;
import dev.Connor.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateEmployeeHandler implements Handler{

    //when we send this a json to the employee endpoints, creates an employee in our hashmap,
    //then sends us back the employee as a form of confirmation

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        // fromJson this is taking something from Json to Java
        Employee employee = gson.fromJson(json, Employee.class);
        Employee registeredEmployee = Driver.employeeDAO.createEmployee(employee);
        // turning the employee back into json
        String employeeJson = gson.toJson(registeredEmployee);
        ctx.status(201);
        ctx.result(employeeJson);
    }

}
