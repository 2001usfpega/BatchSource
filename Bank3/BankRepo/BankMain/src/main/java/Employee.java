import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Customer implements Serializable{
	
	String name;
	String password;
	
	public static ArrayList<Employee> empList = new ArrayList<Employee>();
	
	public Employee(String name, String password) {
		this.name = name;
		this.password = password;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee [name=" + name + ", password=" +password + "]";
	}
	

}
