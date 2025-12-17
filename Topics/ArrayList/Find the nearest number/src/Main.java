import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = (Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        int n = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        int distance = -1;
        while (!numbers.isEmpty()) {
            distance++;
            Integer left = n - distance;
            Integer right = n + distance;
            while (numbers.contains(left)) {
                result.add(left);
                numbers.remove(left);
            }
            while (numbers.contains(right)) {
                result.add(right);
                numbers.remove(right);
            }
            if (!result.isEmpty()) {
                break;
            }
        }
        for (int i = 0; i < result.size(); i++) {
            String prefix = (i > 0) ? " " : "";
            System.out.print(prefix + result.get(i));
        }
        scanner.close();
    }
}