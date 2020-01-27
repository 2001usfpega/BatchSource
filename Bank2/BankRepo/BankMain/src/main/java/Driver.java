
public class Driver {

public static Customer curCustomer;
public static Employee curEmployee;
public static Admin curAdmin;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Section to initialize customer list
//		Customer firstCustomer = new Customer("jason", "password");
//		Customer secondCustomer = new Customer("john", "password");
//		Customer.custList.add(firstCustomer);
//		Customer.custList.add(secondCustomer);
//		IOMethods.writeCustomerFile();
//		
//		
//	Employee firstEmployee = new Employee("Janet", "password");
//	Employee.empList.add(firstEmployee);
//	IOMethods.writeEmployeeList();
//	
//	Admin firstAdmin = new Admin("Jack", "password");
//	Admin.adList.add(firstAdmin);
//	IOMethods.writeAdminList();
		 
		IOMethods.readEmployeefile();
		IOMethods.readAdminfile();
		IOMethods.readCustFile();
		
		//System.out.println(Customer.custList.get(0));
		Menu menu = new Menu();
		menu.startMenu();
		//menu.menu2();
	}

}
