class Person {
    // Do not change these fields
    public static final String DEFAULT_NAME = "Unknown";
    public static final int MAX_AGE = 130;
    public static final int MIN_AGE = 0;
    private String name;
    private int age;

    // Fix the constructor to make its code pass the unit tests
    Person(String name, int age) {
        this.name = (name == null || name.isBlank()) ? DEFAULT_NAME : name;
        this.age = (age < MIN_AGE) ? MIN_AGE : (age > MAX_AGE) ? MAX_AGE : age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Testus {
    public static void main(String[] args) {
        //testPersonCreationValidArgs()
        String name = "Jane Doe";
        int age = Person.MIN_AGE + 23;
        Person person = new Person(name, age);
        System.out.println("testPersonCreationValidArgs:");
        System.out.println(name.equals(person.getName()));
        System.out.println(age == person.getAge());

        //testPersonCreationNegativeAge()
        name = "Jane Doe";
        age = Person.MIN_AGE - 1;
        person = new Person(name, age);
        System.out.println("testPersonCreationNegativeAge:");
        System.out.println(Person.MIN_AGE == person.getAge());

        //testPersonCreationAgeOverUpperLimit()
        name = "Jane Doe";
        age = Person.MAX_AGE + 1;
        person = new Person(name, age);
        System.out.println("testPersonCreationAgeOverUpperLimit:");
        System.out.println(Person.MAX_AGE == person.getAge());

        //testPersonCreationNameNull()
        name = null;
        age = Person.MIN_AGE + 1;
        person = new Person(name, age);
        System.out.println("testPersonCreationNameNull:");
        System.out.println(person.getName() != null);
        System.out.println(Person.DEFAULT_NAME.equals(person.getName()));

        //testPersonCreationNameBlank()
        name = "\t";
        age = Person.MIN_AGE + 1;
        person = new Person(name, age);
        System.out.println("testPersonCreationNameBlank:");
        System.out.println(Person.DEFAULT_NAME.equals(person.getName()));

        //testPersonCreationNameEmpty()
        name = "";
        age = Person.MIN_AGE + 1;
        person = new Person(name, age);
        System.out.println("testPersonCreationNameEmpty:");
        System.out.println(Person.DEFAULT_NAME.equals(person.getName()));
    }
}