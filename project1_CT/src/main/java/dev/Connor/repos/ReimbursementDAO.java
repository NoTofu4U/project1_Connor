package dev.Connor.repos;

import dev.Connor.entities.Employee;
import dev.Connor.entities.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {

    Reimbursement createReimbursement(Reimbursement reimbursement);

    Reimbursement getReimbursement(int reimbursementId);

    List<Reimbursement> getAllReimbursement();

    Reimbursement updatedReimbursement(Reimbursement reimbursement);

}
