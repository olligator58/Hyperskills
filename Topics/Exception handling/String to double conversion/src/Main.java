//import java.util.Scanner;

class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            return 0;
        }
    }
}

/*
class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Converter.convertStringToDouble(scanner.nextLine()));
        scanner.close();
    }
}*/
