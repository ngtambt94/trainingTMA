package Comparator;

import java.util.Comparator;

import compareObjects.Person;

public class comparePersonByAge implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        if(person1.getAge() > person2.getAge()) {
            return 1;
        } else if (person1.getAge() < person2.getAge()) {
            return -1;
        }
        return 0;
    }

}
