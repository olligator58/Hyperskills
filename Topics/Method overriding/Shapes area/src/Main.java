class Shape {
    public double area() {
        return 0;
    }
}

class Triangle extends Shape {
    double height;
    double base;

    @Override
    public double area() {
        return base * height / 2;
    }
}

class Circle extends Shape {
    double radius;

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    double side;

    @Override
    public double area() {
        return side * side;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    @Override
    public double area() {
        return width * height;
    }
}

class Test {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.base = 5;
        triangle.height = 10;
        System.out.println(triangle.area());

        Circle circle = new Circle();
        circle.radius = 25;
        System.out.println(circle.area());

        Square square = new Square();
        square.side = 4;
        System.out.println(square.area());

        Rectangle rectangle = new Rectangle();
        rectangle.width = 6;
        rectangle.height = 3;
        System.out.println(rectangle.area());
    }
}