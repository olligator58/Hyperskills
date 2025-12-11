class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        BurgerStore store = new BurgerStore();
        store.orderBurger("Chinese");
        store.orderBurger("American");
        store.orderBurger("Russian");
    }
}

abstract class BurgerFactory {

    abstract Burger createBurger(String type);

    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are unable to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName());
        burger.putBun();
        burger.putCutlet();
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println(burger.getName() + " ready" + "\n");
        return burger;
    }
}

class BurgerStore extends BurgerFactory {
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case "Chinese":
                return new ChineseBurger("Chinese Burger");
            case "American":
                return new AmericanBurger("American Burger");
            case "Russian":
                return new RussianBurger("Russian Burger");
            default:
                return null;
        }
    }
}

abstract class Burger {
    private String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting patty");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

class ChineseBurger extends Burger {

    public ChineseBurger(String name) {
        super(name);
    }
}

class AmericanBurger extends Burger {

    public AmericanBurger(String name) {
        super(name);
    }
}

class RussianBurger extends Burger {

    public RussianBurger(String name) {
        super(name);
    }
}