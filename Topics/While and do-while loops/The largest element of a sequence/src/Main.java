import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int max = -1;
        do {
            number = scanner.nextInt();
            if (number > max) {
                max = number;
            }
        } while (number != 0);
        System.out.println(max);
        scanner.close();
    }
}