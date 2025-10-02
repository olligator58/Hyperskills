import java.util.Scanner;

class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(String name, int length, int width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    public double calcArea() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int length = scanner.nextInt();
        int width = scanner.nextInt();

        Rectangle rectangle = new Rectangle(name, length, width);
        System.out.println(rectangle.getName());
        System.out.println(rectangle.calcArea());
        scanner.close();
    }
}