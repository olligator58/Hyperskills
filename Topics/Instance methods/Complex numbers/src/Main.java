class Complex {

    double real;
    double image;

    public void add(Complex num) {
        real += num.real;
        image += num.image;
    }

    public void subtract(Complex num) {
        real -= num.real;
        image -= num.image;
    }
}

public class Main {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        c1.real = 10;
        c1.image = 4;

        Complex c2 = new Complex();
        c2.real = 6;
        c2.image = 6;

        c1.add(c2);
        System.out.println(c1.real + " " + c1.image);

        c2.subtract(c1);
        System.out.println(c2.real + " " + c2.image);
    }
}