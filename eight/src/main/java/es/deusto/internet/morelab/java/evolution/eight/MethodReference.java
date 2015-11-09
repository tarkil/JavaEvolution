package es.deusto.internet.morelab.java.evolution.eight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by david on 9/11/15.
 */
public class MethodReference {

    static int compareString(final String a, final String b) {
        return b.compareTo(a);
    }

    static class StringComparator {


        int compareString(final String a, final String b) {
            return a.compareTo(b);
        }

    }

    static class Person {
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        private final String name;

        Person(final String n) {
            name = n;
        }

    }


    public static void main (final String[] args) {

        final String[] names = {"John", "Michael", "Eduard" , "Jame", "Catherin", "George" };

        final List<String> nameList = Arrays.asList(names);

        //With lambdas - inverse order

        System.out.println("Inverse Order");

        nameList.sort((current, other) -> other.compareTo(current));

        for (String name : nameList) {
            System.out.println(name);
        }


        System.out.println("----");

        System.out.println("Alphabetical Order");

        //Reference to an Instance Method of an Arbitrary Object of a Particular Type - alphabetical order
        nameList.sort(String::compareToIgnoreCase);

        for (String name : nameList) {
            System.out.println(name);
        }

        System.out.println("----");


        //Reference to a Static Method - inverse order
        System.out.println("Inverse Order");

        nameList.sort(MethodReference::compareString);

        for (String name : nameList) {
            System.out.println(name);
        }

        //Reference to an Instance Method of an Arbitrary Object of a Particular Type

        System.out.println("----");

        System.out.println("Alphabetical Order");

        //Reference to an Instance Method of an Arbitrary Object of a Particular Type - alphabetical order
        StringComparator comparator = new StringComparator();

        nameList.sort(comparator::compareString);

        for (String name : nameList) {
            System.out.println(name);
        }

        //Reference to a Constructor
        final List<Person> personCollection = nameList.stream().map(Person::new).collect(Collectors.toList());

        for (Person person : personCollection) {
            System.out.println(person);
        }

    }
}
