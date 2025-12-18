import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] names = input.split(",");
        Set<String> set = new LinkedHashSet<>();
        for (String name : names) {
            set.add(name);
        }
        System.out.println(set.toString().replaceAll("[\\[\\]\\s]", ""));
        scanner.close();
    }
}