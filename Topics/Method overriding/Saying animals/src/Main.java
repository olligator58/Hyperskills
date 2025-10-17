class Animal {

    public void say() {
        System.out.println("...An incomprehensible sound...");
    }
}

class Cat extends Animal {

    @Override
    public void say() {
        System.out.println("meow-meow");
    }
}

class Dog extends Animal {

    @Override
    public void say() {
        System.out.println("arf-arf");
    }
}

class Duck extends Animal {

    @Override
    public void say() {
        System.out.println("quack-quack");
    }
}

class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.say();

        Dog dog = new Dog();
        dog.say();

        Duck duck = new Duck();
        duck.say();
    }
}