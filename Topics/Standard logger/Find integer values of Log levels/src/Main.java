import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::toUpperCase)
                .map(Level::parse)
                .mapToInt(Level::intValue)
                .sum()
        );
        scanner.close();
    }
}