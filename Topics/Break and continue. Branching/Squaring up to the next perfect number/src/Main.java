import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int square = 1;

        for (int i = 1; i <= 101; i++) {
            square = i * i;
            if (square > N) {
                break;
            }
        }
        // Print the result here
        System.out.println(square);
        scanner.close();
    }
}