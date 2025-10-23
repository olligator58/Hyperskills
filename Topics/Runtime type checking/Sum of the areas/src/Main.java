class Sum {
    public static int sumOfAreas(Shape[] array) {
        int sum = 0;
        for (Shape shape : array) {
            if (shape instanceof Square square) {
                sum += square.getSide() * square.getSide();
            }
            if (shape instanceof Rectangle rectangle) {
                sum += rectangle.getHeight() * rectangle.getWidth();
            }
        }
        return sum;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Testus {
    public static void main(String[] args) {
        Square square = new Square();
        square.setSide(5);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(6);
        rectangle.setHeight(3);

        Shape[] shapes = new Shape[]{square, rectangle, new Shape(), square};
        System.out.println(Sum.sumOfAreas(shapes));
    }
}