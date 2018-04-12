package debugCode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 4, 5, 6, 7 };

        for (int x : numbers) {
            if (x % 2 == 0) {
                System.out.println(x + " la so chan\n");
            } else {
                System.out.println(x + " la so le\n");
            }
        }

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("abc", 20, "3/2 street"));
        persons.add(new Person("def", 23, "30/04 street"));
        persons.add(new Person("xyz", 25, "Nguyen Van Troi street"));

        for (Person per : persons) {
            per.setName("Name: " + per.getName());
            per.setAge(per.getAge() + 1);
            per.setAddress("Address" + per.getAddress());

            System.out.println(per.toString());
        }

    }

}
