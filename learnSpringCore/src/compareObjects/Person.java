package compareObjects;

import java.util.Comparator;

public class Person implements Comparator<Person> {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compare(Person o1, Person o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        
        int value = o1.getAge() - o2.getAge();
        if (value != 0) {
            return value;
        }
        value = o1.getName().compareTo(o2.getName());
        return value;
    }

}
