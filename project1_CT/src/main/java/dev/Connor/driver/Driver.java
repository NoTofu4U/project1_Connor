package dev.Connor.driver;

import dev.Connor.controllers.EmployeeController;
import dev.Connor.controllers.ReimbursementsController;
import dev.Connor.repos.EmployeeDAOPostgres;
import dev.Connor.repos.ReimbursementDAOLocal;
import dev.Connor.services.EmployeeService;
import dev.Connor.services.EmployeeServiceImp;
import dev.Connor.services.ReimbursementService;
import dev.Connor.services.ReimbursementServiceImp;
import io.javalin.Javalin;

public class Driver {
    // Dependency injection makes us need the EmployeeDAO as an arg on static obj
    public static EmployeeService employeeService = new EmployeeServiceImp(new EmployeeDAOPostgres());
    public static ReimbursementService reimbursementService = new ReimbursementServiceImp(new ReimbursementDAOLocal());
    // the above needs to be updated with ReimbursementDAOPostgres soon tm
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        // Employee app ------------------------------------------------------------------------------------------------
        EmployeeController employeeController = new EmployeeController();

        app.post("/employee", employeeController.createEmployeeHandler); // manager

        //can't do the get, put, or delete first bc we don't have a db to reference
        app.get("/employee/{id}", employeeController.getEmployeeByIdHandler);

        // the path here may need to be updated if changed in Postman
        app.get("/employee/", employeeController.getAllEmployee); // manager

        app.put("/employee/{id}", employeeController.updateEmployeeHandler); // manager

        app.delete("/employee/{id}", employeeController.deleteEmployeeHandler); // manager

        // Reimbursement app -------------------------------------------------------------------------------------------
        ReimbursementsController reimbursementsController = new ReimbursementsController();

        app.post("/reimbursement", reimbursementsController.createReimbursementHandler);

        app.get("/reimbursement/{id}", reimbursementsController.getReimbursementByIdHandler);

        app.get("/reimbursement/", reimbursementsController.getAllReimbursementHandler); // manager

        app.put("/reimbursement/{id}", reimbursementsController.updateReimbursementHandler); // manager

        app.start();
    }

}

// This is some stretch goals I may want to implement
// see about adding different types of reimbursement


// double check that this is the correct path to the main class later
//<mainClass>dev.Connor.driver.Driver</mainClass>
