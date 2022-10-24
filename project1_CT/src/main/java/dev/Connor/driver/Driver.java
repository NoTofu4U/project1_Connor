package dev.Connor.driver;

import dev.Connor.controllers.EmployeeController;
import dev.Connor.repos.EmployeeDAO;
import dev.Connor.repos.EmployeeDAOLocal;
import io.javalin.Javalin;

public class Driver {

    public static EmployeeDAO employeeDAO = new EmployeeDAOLocal();

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        // this replaced all the handlers
        EmployeeController employeeController = new EmployeeController();

        app.post("/employee", employeeController.createEmployeeHandler);

        //can't do the get, put, or delete first bc we don't have a db to reference
        app.get("/employee/{id}", employeeController.getEmployeeByIdHandler);

        app.put("/employee", employeeController.updateEmployeeHandler);

        app.delete("/employee/{id}", employeeController.deleteEmployeeHandler);

        app.start();
    }

}

// This is some stretch goals I may want to implement
// see about adding different types of reimbursement
