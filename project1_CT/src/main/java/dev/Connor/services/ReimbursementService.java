package dev.Connor.services;

import dev.Connor.entities.Reimbursement;

import java.util.List;

public interface ReimbursementService {

    Reimbursement createReimbursement(Reimbursement reimbursement);

    Reimbursement getReimbursementID(int requestId);

    List<Reimbursement> getAllReimbursement();

    Reimbursement updatedReimbursement(Reimbursement reimbursement);

}
