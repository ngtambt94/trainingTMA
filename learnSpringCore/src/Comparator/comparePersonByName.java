package Comparator;

import java.util.Comparator;

import compareObjects.Person;

public class comparePersonByName implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());
    }

}
