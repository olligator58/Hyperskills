import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class Task {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119056591.txt";
    private static final int NUMBER_OF_POUNTS = 10;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            double[][] points = new double[2][NUMBER_OF_POUNTS + 1];
            for (int i = 0; i < NUMBER_OF_POUNTS; i++) {
                double[] point = Arrays.stream(reader.readLine().split(","))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                points[0][i] = point[0];
                points[1][i] = point[1];
            }
            points[0][NUMBER_OF_POUNTS] = points[0][0];
            points[1][NUMBER_OF_POUNTS] = points[1][0];

            //print matrix
            for (int i = 0; i < points.length; i++) {
                System.out.println(Arrays.toString(points[i]));
            }

            double area = 0.0d;
            for (int i = 0; i < points[0].length - 1; i++) {
                area += points[0][i] * points[1][i + 1] - points[0][i + 1] * points[1][i];
            }
            area /= 2.0d;
            Locale.setDefault(Locale.US);
            System.out.printf("%.2f%n", area);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
