package com.revature;

public class EmployeeInfo extends CustomerInfo{
	
	private int EmployeeID;
	private String EUserName;
	private String EPassword;
	
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public String getEUserName() {
		return EUserName;
	}
	public void setEUserName(String eUserName) {
		EUserName = eUserName;
	}
	public String getEPassword() {
		return EPassword;
	}
	public void setEPassword(String ePassword) {
		EPassword = ePassword;
	}



public EmployeeInfo(int employeeID , String eUserName, String ePassword) {
	
	this.EmployeeID = employeeID;
	this.EUserName =  eUserName;
	this.EPassword = ePassword;

}

@Override
public String toString() {
	return "EmployeeInfo [EmployeeID=" + EmployeeID + ", Employee Name =" + EUserName + ", Employee Password ="
			+ EPassword + ", FullName=" + "]";
}
}