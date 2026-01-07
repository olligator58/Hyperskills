import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Task1 {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119058353.txt";
    private static final LocalTime FROM = LocalTime.of(15, 0);
    private static final LocalTime TO = LocalTime.of(15, 30);

    public static void main(String[] args) {
        List<Error> allErrors = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        List<ErrorCounter> counters = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            while (reader.ready()) {
                String[] error = reader.readLine().split("\\s");
                if (error.length > 1) {
                    allErrors.add(new Error(LocalTime.parse(error[0], formatter), error[1]));
                }
            }

            for (Error error : allErrors) {
                Integer counter = counts.get(error.getError());
                counter = (counter != null) ? counter + 1 : 1;
                counts.put(error.getError(), counter);
            }

            counts.forEach((k, v) -> counters.add(new ErrorCounter(k, v)));

            counters.sort(Comparator.comparingInt(ErrorCounter::getCounter));

            String mostCommon = counters.get(counters.size() - 1).getError();
            System.out.printf("Most common: %s%n", mostCommon);

            counts.clear();
            counters.clear();
            for (Error error : allErrors) {
                if (!error.isInInterval() || error.getError().equals(mostCommon)) {
                    continue;
                }
                Integer counter = counts.get(error.getError());
                counter = (counter != null) ? counter + 1 : 1;
                counts.put(error.getError(), counter);
            }
            counts.forEach((k, v) -> counters.add(new ErrorCounter(k, v)));
            counters.sort(Comparator.comparingInt(ErrorCounter::getCounter));
            System.out.printf("Result: %s%n", counters.get(counters.size() - 1).getError());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class Error {
        private LocalTime time;
        private String error;
        private boolean inInterval;

        public Error(LocalTime time, String error) {
            this.time = time;
            this.error = error;
            this.inInterval = !time.isBefore(FROM) && !time.isAfter(TO);
        }

        public String getError() {
            return error;
        }

        public boolean isInInterval() {
            return inInterval;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "time=" + time +
                    ", error='" + error + '\'' +
                    ", isInInterval=" + inInterval +
                    '}';
        }
    }

    static class ErrorCounter {
        private String error;
        private int counter;

        public ErrorCounter(String error, int counter) {
            this.error = error;
            this.counter = counter;
        }

        public String getError() {
            return error;
        }

        public int getCounter() {
            return counter;
        }


        @Override
        public String toString() {
            return "ErrorCounter{" +
                    "error='" + error + '\'' +
                    ", counter=" + counter +
                    '}';
        }
    }
}



