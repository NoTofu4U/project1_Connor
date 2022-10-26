package dev.Connor.repos;

import dev.Connor.entities.Reimbursement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReimbursementDAOLocal implements ReimbursementDAO{

    private Map<Integer, Reimbursement> reimbursementTable = new HashMap();

    private List<Reimbursement> reimbursementList = new ArrayList<>(reimbursementTable.values());
    private int idCount = 1;

    @Override
    public Reimbursement createReimbursement(Reimbursement reimbursement){
        reimbursement.setRequestId(idCount);
        idCount++;
        reimbursementTable.put(reimbursement.getRequestId(), reimbursement);
        System.out.println(reimbursementTable.values());
        reimbursementList.add(reimbursement);
        return reimbursement;
    }

    @Override
    public Reimbursement getReimbursement(int requestId) {
        return reimbursementTable.get(requestId);
    }

    @Override
    public List<Reimbursement> getAllReimbursement(){
        return reimbursementList;
    }

    @Override
    public Reimbursement updatedReimbursement(Reimbursement reimbursement){

        return reimbursementTable.put(reimbursement.getRequestId(), reimbursement);
    }



}
