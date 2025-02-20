import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        // The first operation goes here
        int reminder = input % 2;
        System.out.println(reminder);
        // The second operation goes here
        System.out.println(reminder * 3);
        scanner.close();
    }
}