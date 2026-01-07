import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task7 {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119103906.txt";

    public static void main(String[] args) {
        Map<String, Integer> landmasses = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(",");
                if (line.length > 1) {
                    for (String landmass : line) {
                        Integer counter = Optional.ofNullable(landmasses.get(landmass)).orElse(0) + 1;
                        landmasses.put(landmass, counter);
                    }
                }
            }
            List<Map.Entry<String, Integer>> odds = landmasses.entrySet()
                    .stream()
                    .filter(e -> e.getValue() % 2 != 0)
                    .sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .collect(Collectors.toList());
            System.out.println(odds);
            System.out.printf("Number of odd-degree vertices is: %d%n", odds.size());
            int result = (odds.size() == 0 || odds.size() == 2) ? 0 : odds.size() / 2 - 1;
            System.out.printf("The minimum number of additional bridge crossings required is: %d%n", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
