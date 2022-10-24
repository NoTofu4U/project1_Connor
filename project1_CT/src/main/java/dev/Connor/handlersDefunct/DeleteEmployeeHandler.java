package dev.Connor.handlersDefunct;

import dev.Connor.driver.Driver;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class DeleteEmployeeHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt((ctx.pathParam("id")));
        boolean result = Driver.employeeDAO.deleteEmployeeById(id);
        if (result){
            ctx.status(204);
        } else {
            ctx.status(400);
            ctx.result("Could not process the delete request");
        }
    }
}
