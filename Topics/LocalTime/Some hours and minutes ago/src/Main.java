import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(scanner.nextLine(), formatter);
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        System.out.println(formatter.format(time.minusHours(hours).minusMinutes(minutes)));
        scanner.close();
    }
}