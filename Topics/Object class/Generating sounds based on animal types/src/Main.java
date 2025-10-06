import java.util.*;

public class Main {

    public class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        protected String sound() {
            return "Some sound";
        }
    }

    class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }

        @Override
        protected String sound() {
            return "Bark!";
        }
    }

    class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }

        @Override
        protected String sound() {
            return "Meow!";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String name = scanner.nextLine();

        if("Dog".equals(type)) {
            Dog dog = new Main().new Dog(name);
            System.out.println(dog.sound());
        } else if("Cat".equals(type)) {
            Cat cat = new Main().new Cat(name);
            System.out.println(cat.sound());
        } else {
            System.out.println("Animal type not recognized");
        }
        scanner.close();
    }
} 

