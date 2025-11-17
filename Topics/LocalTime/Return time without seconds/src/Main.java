import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(formatter.format(LocalTime.parse(scanner.nextLine())));
        scanner.close();
    }
}