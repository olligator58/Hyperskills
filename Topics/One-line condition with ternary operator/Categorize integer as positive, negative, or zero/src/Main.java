import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the integer input
        int num = scanner.nextInt();
        System.out.println((num > 0) ? "Positive" :
                          (num < 0) ? "Negative" : "Zero");
        scanner.close();
    }
}