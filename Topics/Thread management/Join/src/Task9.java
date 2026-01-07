import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task9 {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119179455.txt";
    private static final int N = 20;

    public static void main(String[] args) {
        int[][] matrix = new int[N][N];
        Map<Integer, Integer> cells = new HashMap<>();

        int row = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            while (reader.ready()) {
                int[] line = Arrays.stream(reader.readLine().split(","))
                        .filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (line.length == N) {
                    matrix[row] = line;
                    row++;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    cells.put(calcNumber(j, i), Integer.MAX_VALUE);
                }
            }
            cells.put(0, matrix[0][0]);
            Set<Integer> unprocessedNodes = new HashSet<>(cells.keySet());
            while (!unprocessedNodes.isEmpty()) {
                Map.Entry<Integer, Integer> current = findSmallestDistanceNode(unprocessedNodes, cells);
                processNode(current);
                unprocessedNodes.remove(current.getKey());
                Set<Integer> neighbors = findNeighbors(current.getKey());
                for (Integer neighbor : neighbors) {
                    if (unprocessedNodes.contains(neighbor)) {
                        int newDistance = cells.get(current.getKey()) + matrix[getY(neighbor)][getX(neighbor)];
                        if (newDistance < cells.get(neighbor)) {
                            cells.put(neighbor, newDistance);
                        }
                    }
                }
            }
            System.out.printf("The minimum number of lives lost is: %d", cells.get(399));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calcNumber(int x, int y) {
        return y * N + x;
    }

    private static int getX(int number) {
        return number % N;
    }

    private static int getY(int number) {
        return number / N;
    }

    private static Map.Entry<Integer, Integer> findSmallestDistanceNode(Set<Integer> unprocessedNodes, Map<Integer, Integer> cells) {
        return cells.entrySet()
                .stream()
                .filter(e -> unprocessedNodes.contains(e.getKey()))
                .min(Map.Entry.comparingByValue())
                .orElse(null);
    }

    private static void processNode(Map.Entry<Integer, Integer> node) {
        System.out.printf("Visiting %d, x = %d, y = %d, distance = %d%n", node.getKey(), getX(node.getKey()), getY(node.getKey()), node.getValue());
    }

    private static Set<Integer> findNeighbors(int current) {
        Set<Integer> neighbors = new HashSet<>();
        if (getY(current) - 1 >= 0) {
            neighbors.add(calcNumber(getX(current), getY(current) - 1));
        }
        if (getY(current) + 1 < N) {
            neighbors.add(calcNumber(getX(current), getY(current) + 1));
        }
        if (getX(current) - 1 >= 0) {
            neighbors.add(calcNumber(getX(current) - 1, getY(current)));
        }
        if (getX(current) + 1 < N) {
            neighbors.add(calcNumber(getX(current) + 1, getY(current)));
        }
        return neighbors;
    }


}
