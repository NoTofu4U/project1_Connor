package dev.Connor.entities;

public class Reimbursement {
    private int requestId;
    private int employeeIdForeign; // foreign key
    private int amount;
    private String description;
    private Status status; // foreign key
    private String reimbursementType; //(Travel, Lodging, Food, other)

    // in DB it's requestId, amount, r_types, description, s_id (foreign), employeeid(foreign)

    public Reimbursement() {
    }

    public Reimbursement(int requestId, int employeeId, int amount, String description, Status status, String reimbursementType){
        this.requestId = requestId;
        this.employeeIdForeign = employeeId;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.reimbursementType = reimbursementType;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "requestId=" + requestId +
                ", employeeId=" + employeeIdForeign +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getEmployeeId() {
        return employeeIdForeign;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeIdForeign = employeeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }
    //reimbursement.getStatus().name();
    // ror requests in the DAO
    //reimbursement.valueOf(rs.get(String("status")));

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }
}
