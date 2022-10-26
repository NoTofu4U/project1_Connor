package dev.Connor.controllers;

import com.google.gson.Gson;
import dev.Connor.driver.Driver;
import dev.Connor.entities.Employee;
import dev.Connor.entities.Reimbursement;
import io.javalin.http.Handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReimbursementsController {

    private Map<Integer, Reimbursement> reimbursementTable = new HashMap();

    public Handler createReimbursementHandler = (ctx) ->{
        String json = ctx.body();
        Gson gson = new Gson();
        Reimbursement reimbursement = gson.fromJson(json, Reimbursement.class);
        Reimbursement registeredReimbursement = Driver.reimbursementService.createReimbursement(reimbursement);
        String reimbursementJson = gson.toJson(registeredReimbursement);
        ctx.status(201);
        ctx.result(reimbursementJson);
    };

    public Handler getAllReimbursementHandler = (ctx) -> {
        List<Reimbursement> reimbursementList = Driver.reimbursementService.getAllReimbursement();
        Gson gson = new Gson();
        String json = gson.toJson(reimbursementList);
        ctx.result(json);
    };

    public Handler getReimbursementByIdHandler = (ctx) ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        // the getReimbursementID may not be correct
        Reimbursement reimbursement = Driver.reimbursementService.getReimbursementID(id);
        Gson gson = new Gson();
        String json = gson.toJson(reimbursement);
        ctx.result(json);
    };

    public Handler updateReimbursementHandler = (ctx) ->{
        String reimbursementJSON = ctx.body();
        Gson gson = new Gson();
        Reimbursement reimbursement = gson.fromJson(reimbursementJSON, Reimbursement.class);
        Reimbursement updatedReimbursement = Driver.reimbursementService.updatedReimbursement(reimbursement);
        String json = gson.toJson(updatedReimbursement);
        ctx.result(json);
    };

}
