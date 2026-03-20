import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();
//        Pattern pattern = Pattern.compile("\\b" + part + "[A-Za-z]+|[A-Za-z]+" + part + "\\b", Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("\\b" + part + "|" + part + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        System.out.println((matcher.find()) ? "YES" : "NO");
        scanner.close();
    }
}