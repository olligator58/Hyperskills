import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(LocalDateTime.parse(scanner.nextLine()).minusHours(scanner.nextInt()).plusMinutes(scanner.nextInt()));
        scanner.close();
    }
}