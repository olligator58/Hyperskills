import java.util.Scanner;

interface Shape {
    default String name() {
        return "Generic Shape";
    }
}

interface Colorable {
    default String color() {
        return "No Color";
    }
}

class Circle implements Shape, Colorable {
    @Override
    public String name() {
        return "Circle";
    }
}

class ColoredCircle extends Circle {
    @Override
    public String color() {
        return "Red";
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        Circle circle = null;
        if ("Circle".equals(type)) {
            circle = new Circle();
        } else if ("ColoredCircle".equals(type)) {
            circle = new ColoredCircle();
        }
        if (circle != null) {
            System.out.println(circle.name());
            System.out.println(circle.color());
        }
        scanner.close();
    }
}