class Circle {

    double radius;

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 4;
        System.out.println("length: " + circle.getLength());
        System.out.println("area: " + circle.getArea());
    }
}