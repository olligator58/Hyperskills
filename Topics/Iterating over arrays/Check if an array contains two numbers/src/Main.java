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
        int m = sc.nextInt();

        boolean contains = false;

        for (int i = 0; i < numbers.length - 1; i++) {
            if ((numbers[i] == n && numbers[i + 1] == m) || (numbers[i] == m && numbers[i + 1] == n)) {
                contains = true;
                break;
            }
        }
        System.out.println(contains);
        sc.close();
    }
}