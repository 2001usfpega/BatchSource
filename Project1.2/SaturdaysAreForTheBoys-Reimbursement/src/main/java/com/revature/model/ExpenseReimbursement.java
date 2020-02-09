package com.revature.model;

import java.sql.Date;

public class ExpenseReimbursement {
    private int id;
    private String firstName;
    private String lastName;
    private String reimbursementType;
    private double expenseReimburseAmount;
    private Date submitDate;
    private Date decisionDate;
    private int status;
    private String expenseReimburseDescription;

    public ExpenseReimbursement(int id, String firstName, String lastName, String reimbursementType,
                                double expenseReimburseAmount, Date submitDate, Date decisionDate, int status,
                                String expenseReimburseDescription) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reimbursementType = reimbursementType;
        this.expenseReimburseAmount = expenseReimburseAmount;
        this.submitDate = submitDate;
        this.decisionDate = decisionDate;
        this.status = status;
        this.expenseReimburseDescription = expenseReimburseDescription;
    }

    @Override
    public String toString() {
        return "ExpenseReimbursement [expenseReimburseType=" + id + ", firstName=" + firstName
                + ", lasgtName=" + lastName + ", reimbursementType=" + reimbursementType + ", expenseReimburseAmount="
                + expenseReimburseAmount + ", submitDate=" + submitDate + ", decisionDate=" + decisionDate + ", status="
                + status + ", expenseReimburseDescription=" + expenseReimburseDescription + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReimbursementType() {
        return reimbursementType;
    }

    public void setReimbursementType(String reimbursementType) {
        this.reimbursementType = reimbursementType;
    }

    public double getExpenseReimburseAmount() {
        return expenseReimburseAmount;
    }

    public void setExpenseReimburseAmount(double expenseReimburseAmount) {
        this.expenseReimburseAmount = expenseReimburseAmount;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExpenseReimburseDescription() {
        return expenseReimburseDescription;
    }

    public void setExpenseReimburseDescription(String expenseReimburseDescription) {
        this.expenseReimburseDescription = expenseReimburseDescription;
    }
}