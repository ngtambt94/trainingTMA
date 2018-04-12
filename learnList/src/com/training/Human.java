package com.training;

public abstract class Human {
	private String name;
	private int age;
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void show() {
		System.out.println(this.name + " is " + this.age);
	}
}
