package classAndObject;

public class MainApp {
	public static void main(String[] args) {
		Employee emp = new Employee("Tam Nguyen");
		emp.setAge(25);
		emp.setDesignation("Engineer");
		emp.setSalary(7.5);
		emp.printInfo();
	}	
}
