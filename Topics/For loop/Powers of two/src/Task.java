// You can experiment here, it won’t be checked

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();
        for (long i = 1; i < num; i *= 2) {
            System.out.println(i);
        }
    }
}
