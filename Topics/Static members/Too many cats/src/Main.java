class Cat {
    private String name;
    private int age;
    private static int counter = 0;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return counter;
    }
}

class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 4);
        cat = new Cat("Vaska", 5);
        cat = new Cat("Vaska", 5);
        cat = new Cat("Vaska", 5);
        cat = new Cat("Vaska", 5);
        System.out.println(Cat.getNumberOfCats());
        cat = new Cat("Vaska", 5);
        cat = new Cat("Vaska", 5);
        System.out.println(Cat.getNumberOfCats());
    }
}