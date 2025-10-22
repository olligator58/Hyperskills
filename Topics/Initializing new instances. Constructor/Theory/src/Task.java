import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-117253038.txt";
    //private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-117253038-test.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {

            String line = reader.readLine();
            System.out.println(line.length());
            System.out.println(line);
            int[] counts = new int[10];

            for (int i = 0; i < line.length(); i++) {
                int number = Integer.parseInt(String.valueOf(line.charAt(i)));
                counts[number]++;
            }
            System.out.println(Arrays.toString(counts));

            List<Digit> digits = new ArrayList<>();
            for (int i = 0; i < counts.length; i++) {
                digits.add(new Digit(i, counts[i]));
            }

            System.out.println(digits);

            Collections.sort(digits);

            System.out.println("После сортировки:");

            System.out.println(digits);

            for (int i = 0; i < 4; i++) {
                System.out.print(digits.get(i).digit);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Digit implements Comparable<Digit> {
        int digit;
        int counter;

        public Digit(int digit, int counter) {
            this.digit = digit;
            this.counter = counter;
        }

        @Override
        public int compareTo(Digit digit) {
            if (digit.counter != this.counter) {
                return digit.counter - this.counter;
            }
            return digit.digit - this.digit;
        }

        @Override
        public String toString() {
            return "Digit{" +
                    "digit=" + digit +
                    ", counter=" + counter +
                    '}';
        }
    }
}
