import java.util.Scanner;
import java.util.Arrays;

class Main {

    private static void rotate(int[] arr, int steps) {
        int[] copy = new int[arr.length];

        steps = steps % arr.length;

        for (int i = 0; i < arr.length; i++) {
            int newPosition = i + steps;
            if (newPosition > arr.length - 1) {
                newPosition -= arr.length;
            }
            copy[newPosition] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = copy[i];
        }
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}