package com.revature.DAO;

import com.revature.model.Employee;
import com.revature.model.ExpenseReimbursement;

import java.util.List;

public interface ExpenseReimbursementDAO {


    void employeeSubmitReimburse(int rType, double rAmount, String empFK, String descrip);

    void resolveReimburse(String finManForeignKey, boolean approved, int reimburseID);

    Employee login(String man_username, String man_password);

    List<ExpenseReimbursement> viewPending();
}