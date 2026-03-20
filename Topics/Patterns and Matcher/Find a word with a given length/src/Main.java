import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\b");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group().length() == size) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
        scanner.close();
    }
}