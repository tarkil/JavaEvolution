package es.deusto.internet.morelab.java.evolution.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by david on 22/11/15.
 */
public class StreamExample {

    static class Person {
        private final int age;
        private final String name;

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public Person(String n, int a)  {
            name = n;
            age = a;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static  List<Person> getAdultListWithoutStreams(List<Person> personList) {

        List<Person> adultList = new ArrayList<>();

        for (Person person : personList) {
            if (person.getAge() >= 18) {
                adultList.add(person);
            }
        }

        return adultList;
    }

    public static  List<Person> getAdultListWithStreams(List<Person> personList) {

        return personList.stream().filter(p -> p.getAge() >= 18)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("David", 3));
        personList.add(new Person("John", 13));
        personList.add(new Person("Michael", 43));
        personList.add(new Person("Agatha", 33));
        personList.add(new Person("Lucy", 16));
        personList.add(new Person("Zoey", 84));

        System.out.println("Adults with streams");

        for (Person person : getAdultListWithoutStreams(personList)) {
            System.out.println(person);
        }

        System.out.println("\n------------------------------\n");
        System.out.println("Adults without streams");

        getAdultListWithStreams(personList).forEach(person -> System.out.println(person));


    }
}
