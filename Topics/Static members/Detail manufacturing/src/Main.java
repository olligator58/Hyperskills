import java.util.Scanner;

class ManufacturingController {
    private static int counter = 0;

    public static String requestProduct(String product) {
        counter++;
        return String.format("%d. Requested %s", counter, product);
    }

    public static int getNumberOfProducts() {
        return counter;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String product = scanner.nextLine();
            System.out.println(ManufacturingController.requestProduct(product));
            System.out.println(ManufacturingController.getNumberOfProducts());
        }
    }
}