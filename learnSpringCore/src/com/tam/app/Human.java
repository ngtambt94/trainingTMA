package com.tam.app;

public class Human {
    private String name;
    private String age;
    private String address;
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Human() {}

    public Human(String name, String age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    public void onCreate() {
        System.out.println("Hi! You created me! :)");
    }

    public void onDestroy() {
        System.out.println("Oh! It's time to say goodbye! :(");
    }
    
    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + ", address=" + address + "]";
    }

    
    
}
