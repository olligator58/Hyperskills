import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int height;
    private int weight;

    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (!name.equals(otherPerson.name)) {
            return name.compareTo(otherPerson.name);
        }
        return Integer.valueOf(age).compareTo(otherPerson.age);
    }

/*
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
*/
}

class Testus {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Tom", 22, 185, 65));
        persons.add(new Person("Bob", 22, 175, 85));
        persons.add(new Person("Kris", 30, 180, 90));
        persons.add(new Person("Bob", 21, 175, 85));
        persons.add(new Person("Kris", 29, 180, 90));
        Collections.sort(persons);
        persons.forEach(System.out::println);
    }
}