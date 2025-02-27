import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read the user input
        Scanner scanner = new Scanner(System.in);

        // Read an integer from the user
        int n = scanner.nextInt();

        if (n < 5) {
            System.out.println("LOW");
        } else if (n == 5) {
            System.out.println("MID");
        } else {
            System.out.println("HIGH");
        }
    }
}