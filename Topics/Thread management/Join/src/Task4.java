import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Task4 {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119080292.txt";

    public static void main(String[] args) {
        Set<String> forks = new HashSet<>(Set.of("1", "2", "3", "4"));
        int i = 1;
        int contentions = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(",");
                if (line.length > 2) {
                    String name = line[0];
                    String action = line[1];
                    String fork = line[2];
                    if ("release".equals(action) && !forks.contains(fork)) {
                        forks.add(fork);
                        System.out.printf("%d: %s released %s%n", i, name, fork);
                    } else if ("pick".equals(action)) {
                        if (forks.contains(fork)) {
                            forks.remove(fork);
                            System.out.printf("%d: %s picked %s%n", i, name, fork);
                        } else {
                            System.out.printf("%d: %s wanted to pick %s. Contention !!!%n", i, name, fork);
                            contentions++;
                        }
                    }
                }
                i++;
            }
            System.out.printf("Number of contensions: %d%n", contentions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
