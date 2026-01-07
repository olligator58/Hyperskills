import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task6 {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119081148.txt";
    private static Map<String, Integer> visits = new HashMap<>();

    public static void main(String[] args) {

        List<String> rules = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            String first = reader.readLine();
            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.isEmpty()) {
                    rules.add(line);
                }
            }
            visits.put(first, 0);
            queue.add(first);
            while (!queue.isEmpty()) {
                String current = queue.remove();
                processNode(current);
                for (String rule : rules) {
                    String[] route = rule.split(",");
                    String from = route[0];
                    String to = route[1];
                    if (from.equals(current) && !visits.containsKey(to)) {
                        visits.put(to, visits.get(current) + 1);
                        queue.add(to);
                    }
                }
            }
            Comparator<Map.Entry<String, Integer>> comparator = (e1, e2) -> {
                if (e1.getValue().compareTo(e2.getValue()) != 0) {
                    return e1.getValue().compareTo(e2.getValue());
                }
                return e1.getKey().compareTo(e2.getKey());
            };
            List<Map.Entry<String, Integer>> result = visits.entrySet().stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
            System.out.println(result);
            int maxDistance = result.get(result.size() - 1).getValue();
            for (Map.Entry<String, Integer> entry : result) {
                if (entry.getValue() == maxDistance) {
                    System.out.printf("The name of the being who is furthest from the starting one is: %s%n", entry.getKey());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processNode(String node) {
        System.out.printf("Visiting node: %s. It's distance is %d%n", node, visits.get(node));
    }
}
