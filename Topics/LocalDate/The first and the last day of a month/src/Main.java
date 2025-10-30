import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate beginOfMonth = LocalDate.of(year, month, 1);
        LocalDate endOfMonth = beginOfMonth.plusMonths(1).minusDays(1);
        System.out.println(String.format("%s %s", beginOfMonth, endOfMonth));
        scanner.close();
    }
}