import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrLength = sc.nextInt();
        int[] numbers = new int[arrLength];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int counter = 0;

        for (int number : numbers) {
            if (number == n) {
                counter++;
            }
        }
        System.out.println(counter);
        sc.close();
    }
}