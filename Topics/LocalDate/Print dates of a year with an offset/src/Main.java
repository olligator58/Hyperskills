import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        int offset = scanner.nextInt();
        LocalDate newDate = startDate;
        while (newDate.getYear() == startDate.getYear()) {
            System.out.println(newDate);
            newDate = newDate.plusDays(offset);
        }
        scanner.close();
    }
}