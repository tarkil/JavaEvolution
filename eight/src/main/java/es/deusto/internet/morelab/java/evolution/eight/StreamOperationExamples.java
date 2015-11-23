package es.deusto.internet.morelab.java.evolution.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by david on 22/11/15.
 */
public class StreamOperationExamples {




    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("David", 3));
        personList.add(new Person("John", 13));
        personList.add(new Person("Michael", 43));
        personList.add(new Person("Agatha", 33));
        personList.add(new Person("Lucy", 16));
        personList.add(new Person("Zoey", 84));
        personList.add(new Person("Zoey", 84));


        filterByAgeExample(personList);

        mapToUserExample(personList);

        limitToThreePerson(personList);

        sortedPersonListByName(personList);

        distinctPersonList(personList);

        discardTheThreeFirstElements(personList);

        anyAdultPerson(personList);

        areTheyAdults(personList);

        findAnyPerson(personList);

        findFirstPerson(personList);

        totalAge(personList);


        List<Course> courses = new ArrayList<>();

        Course temp = new Course("Math");
        temp.getStudents().add(personList.get(0));
        temp.getStudents().add(personList.get(3));
        temp.getStudents().add(personList.get(2));

        courses.add(temp);

        temp = new Course("Biology");
        temp.getStudents().add(personList.get(0));
        temp.getStudents().add(personList.get(1));
        temp.getStudents().add(personList.get(4));
        courses.add(temp);

        getListOfStudentsWithFlatMapAndDistinct(courses);

        countCourses(courses);




    }

    private static void totalAge(List<Person> personList) {
        System.out.println("\n Total age");

        OptionalInt totalAge = personList.stream().mapToInt(p -> p.getAge()).reduce((a, b) -> a + b);

        if (totalAge.isPresent()) {
            System.out.println("Total Age " + totalAge.getAsInt());
        } else {
            System.out.println("Total age " + 0);
        }

    }

    private static void findFirstPerson(List<Person> personList) {
        System.out.println("\n Find first person");

        Optional<Person> person = personList.stream().findAny();
        if (person.isPresent()) {
            System.out.println("First person " + person);
        } else {
            System.out.println("No person available");
        }
    }
    private static void findAnyPerson(List<Person> personList) {
        System.out.println("\n Find any person");

        Optional<Person> person = personList.stream().findAny();
        if (person.isPresent()) {
            System.out.println("Available person " + person);
        } else {
            System.out.println("No person available");
        }
    }

    private static void areTheyAdults(List<Person> personList) {
        System.out.println(" Are they adults? with all match: " + personList.stream().allMatch(p -> p.getAge() >= 18));
        System.out.println(" Are they adults? with none match: " + personList.stream().noneMatch(p -> p.getAge() < 18));

    }

    private static void anyAdultPerson(List<Person> personList) {
        System.out.println(" Is there any adult person?: " + personList.stream().anyMatch(p -> p.getAge() >= 18));
    }

    private static void countCourses(List<Course> courses) {
        System.out.println("\n Number of courses");

        System.out.println(courses.stream().count());
    }

    private static void getListOfStudentsWithFlatMapAndDistinct(List<Course> courses) {
        System.out.println("\n Get list of students");
        courses.stream().flatMap(s -> s.getStudents().stream()).distinct().forEach(p -> System.out.println(p));
    }


    private static void discardTheThreeFirstElements(List<Person> personList) {
        System.out.println("\n Discard the three first element of the list");
        personList.stream().skip(3L).forEach(p -> System.out.println(p));
    }

    private static void distinctPersonList(List<Person> personList) {
        System.out.println("\n Distinct Person list");
        personList.stream().distinct().forEach(p -> System.out.println(p));
    }

    private static void sortedPersonListByName(List<Person> personList) {
        System.out.println("\n Sorted Person list by name");
        personList.stream().sorted((p , c) -> p.getName().compareTo(c.getName())).forEach(p -> System.out.println(p));
    }

    private static void limitToThreePerson(List<Person> personList) {
        System.out.println("\n Limit to three Person");
        personList.stream().limit(3).forEach(p -> System.out.println(p));
    }

    private static void mapToUserExample(List<Person> personList) {
        System.out.println("\n Map to User");
        personList.stream().map(p -> new User(p.getName(), p.getAge())).forEach(p -> System.out.println(p));
    }

    private static void filterByAgeExample(List<Person> personList) {
        System.out.println("\n Filter by age");
        personList.stream().filter(p -> p.getAge() >= 18).forEach(p -> System.out.println(p));
    }

    private static class Course {
        private String courseName;
        private List<Person> students;

        public Course(final String name) {
            students = new ArrayList<>();
            courseName = name;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "courseName='" + courseName + '\'' +
                    ", students=" + students +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Course course = (Course) o;

            if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null) return false;
            return !(students != null ? !students.equals(course.students) : course.students != null);

        }

        @Override
        public int hashCode() {
            int result = courseName != null ? courseName.hashCode() : 0;
            result = 31 * result + (students != null ? students.hashCode() : 0);
            return result;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public List<Person> getStudents() {
            return students;
        }

        public void setStudents(List<Person> students) {
            this.students = students;
        }
    }

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return !(name != null ? !name.equals(person.name) : person.name != null);

        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    static class User {
        private final int age;
        private final String name;

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public User(String n, int a)  {
            name = n;
            age = a;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
