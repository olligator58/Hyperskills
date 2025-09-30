class Box {

    double height;
    double width;
    double length;

    public double getVolume() {
        return height * width * length;
    }
}

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        box.height = 3;
        box.width = 5;
        box.length = 7;

        System.out.println(box.getVolume());
    }
}