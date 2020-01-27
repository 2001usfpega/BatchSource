
public class Driver {

public static Customer curCustomer;
public static Employee curEmployee;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Customer firstCustomer = new Customer("jason", "password");
//		Customer secondCustomer = new Customer("john", "password");
//		Customer.custList.add(firstCustomer);
//		Customer.custList.add(secondCustomer);
//		IOMethods.writeCustomerFile();
		
		
//		Employee firstEmployee = new Employee("Janet", "password");
//		Employee.empList.add(firstEmployee);
//		IOMethods.writeEmployeeList();
		 
		IOMethods.readEmployeefile();
		
		IOMethods.readCustFile();
		
		//System.out.println(Customer.custList.get(0));
		Menu menu = new Menu();
		menu.startMenu();
		//menu.menu2();
	}

}
