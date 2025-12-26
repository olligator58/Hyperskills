import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Task {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-118982875.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            int target = Integer.parseInt(scanner.nextLine());

            int[] levels = Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(levels.length);
            double[][] averages = new double[levels.length][levels.length];
            for (int i = 0; i < averages.length; i++) {
                for (int j = 0; j < averages[0].length; j++) {
                    averages[i][j] = (i != j) ? ((levels[i] + levels[j]) / 2.0d) : -1.0d;
                }
            }

            double minDifference = Integer.MAX_VALUE;
            double result = -1.0d;
            int x = -1;
            int y = -1;
            for (int i = 0; i < averages.length; i++) {
                for (int j = 0; j < averages[0].length; j++) {
                    if (i == j) {
                        continue;
                    }
                    double difference = Math.abs(averages[i][j] - target);
                    if (difference < minDifference) {
                        minDifference = difference;
                        result = averages[i][j];
                        x = j;
                        y = i;
                    }
                }
            }


            for (int i = 0; i < 200/*averages.length*/; i++) {
                System.out.println(Arrays.toString(averages[i]));
            }

            System.out.println(String.format("Minimal difference = %f, result = %.0f", minDifference, result));
            System.out.println(String.format("x = %d, y = %d, levels(x) = %d, levels(y) = %d", x, y, levels[x], levels[y]));

        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
