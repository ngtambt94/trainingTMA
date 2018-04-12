package compareObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Comparator.comparePersonByAge;
import Comparator.comparePersonByName;

public class Main {

    public static <T> void main(String[] args) {
        int a = 10;
        float b = 10;
        String str1 = "hello";
        String str2 = "Hello";
        
        Person per1 = new Person("Tam Nguyen", 24);
        Person per2 = new Person("Quyen Tran", 23);
        Person per3 = new Person("Tam Nguyen", 23);
        Person per4 = new Person("ABC", 26);
        
        School school1 = new School("Can Tho University", "Can Tho");
        School school2 = new School("University of Information Technology", "HCMC");
        School school3 = new School("An Giang University", "An Giang");
        
        List<School> schools = new ArrayList<School>();
        schools.add(school1);
        schools.add(school2);
        schools.add(school3);
        
        List<Person> persons = new ArrayList<Person>();
        persons.add(per1);
        persons.add(per2);
        persons.add(per4);
        
        Collections.sort(schools);
        Collections.sort(persons, new comparePersonByName());
        
        System.out.println(a == b);
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));
        System.out.println(per1 == per3);
        System.out.println(per1.equals(per2));
        System.out.println(per1.equals(per3));
        
        System.out.println("\n=====Class School=====\n");
        for(School school: schools)
            System.out.println(school.toString() + "\n");
        
        System.out.println("\n=====Class Person=====\n");
        for(Person person: persons)
            System.out.println(person.toString() + "\n");
    }

}
