import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine()).plusMinutes(scanner.nextInt());
        System.out.println(String.format("%s %s %s", dateTime.getYear(), dateTime.getDayOfYear(), dateTime.toLocalTime()));
        scanner.close();
    }
}