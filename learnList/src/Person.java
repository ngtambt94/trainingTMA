
public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void show() {
		System.out.println("Mr." + this.name + " is " + this.age + " yearsold");
	}
	
	public static void main(String[] args) {
		Person tam = new Person("Tam Nguyen", 25);
		tam.show();
	}
}


