package dev.Connor.services;

import dev.Connor.entities.Employee;
import dev.Connor.entities.Reimbursement;
import dev.Connor.repos.EmployeeDAO;
import dev.Connor.repos.ReimbursementDAO;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementServiceImp implements ReimbursementService{

    private ReimbursementDAO reimbursementDAO;
    private List<Reimbursement> reimbursementList = new ArrayList<>();

    public ReimbursementServiceImp(ReimbursementDAO reimbursement){
        this.reimbursementDAO = reimbursement;
    }

    @Override
    public Reimbursement createReimbursement(Reimbursement reimbursement) {
        if(reimbursement.getEmployeeId() == 0){
            throw new RuntimeException("An Employee must be attatched to a request");
        }
        // double check here that the status is correct (we'll use status codes)
        // 202 - Accepted
        // 201 - Created
        // 400 - Bad Request (kinda like a denied)
        Reimbursement savedReimbursement = this.reimbursementDAO.createReimbursement(reimbursement);
        return savedReimbursement;
    }

    @Override
    public Reimbursement getReimbursementID(int requestId) {

        return this.reimbursementDAO.getReimbursement(requestId);
    }

    @Override
    public List<Reimbursement> getAllReimbursement() {

        return this.reimbursementDAO.getAllReimbursement();
    }

    @Override
    public Reimbursement updatedReimbursement(Reimbursement reimbursement) {

        return this.reimbursementDAO.updatedReimbursement(reimbursement);
    }
}
