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
    private int width;
    private int height;

    public Rectangle(String name, int width, int height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        Rectangle rectangle = new Rectangle(name, width, height);
        System.out.println(String.format("Name: %s", rectangle.getName()));
        System.out.println(String.format("Width: %d", rectangle.getWidth()));
        System.out.println(String.format("Height: %d", rectangle.getHeight()));
        scanner.close();
    }
}