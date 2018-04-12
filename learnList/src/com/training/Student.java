package com.training;


public class Student extends Human {
	
	private String mssv;

	public Student(String name, int age) {
		super(name, age);
	}

	public static void main(String[] args) {
		Human human = new Student("Tam Nguyen", 25);
		human.show();
	}
}
