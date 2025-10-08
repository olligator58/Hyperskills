class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        String name = p1.name;
        int age = p1.age;
        p1.name = p2.name;
        p1.age = p2.age;
        p2.name = name;
        p2.age = age;
    }
}

class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "John Pavelski";
        p1.age = 35;

        Person p2 = new Person();
        p2.name = "Sarah Connor";
        p2.age = 69;

        print(p1);
        print(p2);
        MakingChanges.changeIdentities(p1, p2);
        print(p1);
        print(p2);
    }

    public static void print(Person person) {
        System.out.println("Person{" +
                "name='" + person.name + '\'' +
                ", age=" + person.age +
                '}');
    }
}