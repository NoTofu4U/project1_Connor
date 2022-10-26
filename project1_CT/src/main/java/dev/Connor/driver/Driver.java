package dev.Connor.driver;

import dev.Connor.controllers.EmployeeController;
import dev.Connor.controllers.ReimbursementsController;
import dev.Connor.repos.EmployeeDAO;
import dev.Connor.repos.EmployeeDAOLocal;
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

        // Employee app
        EmployeeController employeeController = new EmployeeController();

        app.post("/employee", employeeController.createEmployeeHandler);

        //can't do the get, put, or delete first bc we don't have a db to reference
        app.get("/employee/{id}", employeeController.getEmployeeByIdHandler);

        // the path here may need to be updated if changed in Postman
        app.get("/employee/", employeeController.getAllEmployee);

        app.put("/employee/{id}", employeeController.updateEmployeeHandler);

        app.delete("/employee/{id}", employeeController.deleteEmployeeHandler);

        // Reimbursement app
        ReimbursementsController reimbursementsController = new ReimbursementsController();

        app.post("/reimbursement", reimbursementsController.createReimbursementHandler);

        app.get("/reimbursement/{id}", reimbursementsController.getReimbursementByIdHandler);

        app.get("/reimbursement/", reimbursementsController.getAllReimbursementHandler);

        app.put("/reimbursement/{id}", reimbursementsController.updateReimbursementHandler);

        app.start();
    }

}

// This is some stretch goals I may want to implement
// see about adding different types of reimbursement
