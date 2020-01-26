package com.revature.question7;

public class Employee {
	
	//create variables for comparing
	
		String name;

		int age;

		String department;

		public Employee(String name, int age, String department) {
			super();
			this.name = name;
			this.age = age;
			this.department = department;
		}
//create getters and setters for each variable
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}
//create a toString for the print out to follow
		@Override
		public String toString() {
			return "Employee [Name= " + name + ", Age= " + age + ", Department= " + department + "]";
		}
		
		
	
}