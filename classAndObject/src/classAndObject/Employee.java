package classAndObject;

public class Employee {
	String name;
	int age;
	String designation;
	double salary;
	
//	this is constructor
	public Employee(String name) {
		this.name = name;
	}
	
//	some methods of class employee
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void printInfo() {
		System.out.print("Employee: " + name);
		System.out.print("\nAge: " + age);
		System.out.print("\nDesignation: " + designation);
		System.out.print("\nSalary: " + salary);
		System.out.print("\n=====That's all=====\n");
	}
	
}
