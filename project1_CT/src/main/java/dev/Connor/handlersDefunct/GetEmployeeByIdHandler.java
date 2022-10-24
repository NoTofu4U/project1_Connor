package dev.Connor.handlersDefunct;

import com.google.gson.Gson;
import dev.Connor.driver.Driver;
import dev.Connor.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetEmployeeByIdHandler implements Handler{

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        // this takes the path{id} and turns it into an int for use
        int id = Integer.parseInt(ctx.pathParam("id"));
        Employee employee = Driver.employeeDAO.getEmployeeID(id);
        Gson gson = new Gson(); //Gson derillo
        String json = gson.toJson(employee);
        ctx.result(json);

    }

}
