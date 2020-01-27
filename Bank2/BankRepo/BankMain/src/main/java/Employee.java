import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Customer implements Serializable{
	
	
	public static final long serialVersionUID = -470081244094378942L;
	public static ArrayList<Employee> empList = new ArrayList<Employee>();
	
	public Employee(String name, String password) {
		super(name, password);
		
	}
	
	
	
	
}
