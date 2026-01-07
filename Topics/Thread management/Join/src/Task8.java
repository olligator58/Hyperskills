import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task8 {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119195113.txt";
    private static final List<Queen> queens = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            while (reader.ready()) {
                int[] lines = Arrays.stream(reader.readLine().split(","))
                        .filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (lines.length > 1) {
                    queens.add(new Queen(lines[1], lines[0]));
                }
            }
            List<Pair> pairs = new ArrayList<>();
            for (int i = 1; i <= queens.size(); i++) {
                for (int j = 1; j <= queens.size(); j++) {
                    if (i < j) {
                        pairs.add(new Pair(queens.get(i - 1), queens.get(j - 1)));
                    }
                }
            }

            List<Pair> result = new ArrayList<>();
            for (Pair pair : pairs) {
                if (pair.attacks()) {
                    result.add(pair);
                }
            }
            System.out.println(result);
            System.out.printf("The number of queen pairs that are attacking each other is: %d", result.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Queen {
        private int id;
        private int x;
        private int y;
        private static int counter = 0;

        public Queen(int x, int y) {
            this.id = ++counter;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Queen{" +
                    "id=" + id +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Pair {
        private Queen queen1;
        private Queen queen2;

        public Pair(Queen queen1, Queen queen2) {
            this.queen1 = queen1;
            this.queen2 = queen2;
        }

        private boolean onTheSameRow() {
            if (queen1.y != queen2.y) {
                return false;
            }
            /*for (Queen queen : queens) {
                if (queen.y == queen1.y && queen.x > Math.min(queen1.x, queen2.x) && queen.x < Math.max(queen1.x, queen2.x)) {
                    return false;
                }
            }*/
            return true;
        }

        private boolean onTheSameColumn() {
            if (queen1.x != queen2.x) {
                return false;
            }
            /*for (Queen queen : queens) {
                if (queen.x == queen1.x && queen.y > Math.min(queen1.y, queen2.y) && queen.y < Math.max(queen1.y, queen2.y)) {
                    return false;
                }
            }*/
            return true;
        }

        private boolean onTheDiagonal() {
            if (Math.abs(queen1.x - queen2.x) != Math.abs(queen1.y - queen2.y)) {
                return false;
            }
            /*int dx = queen2.x - queen1.x;
            int dy = queen2.y - queen1.y;

            for (Queen queen : queens) {
                if (queen.id == queen1.id || queen.id == queen2.id) {
                    continue;
                }
                int dx1 = queen.x - queen1.x;
                int dy1 = queen.y - queen1.y;
                if (Math.abs(dx1) != Math.abs(dy1)) {
                    continue;
                }
                boolean less = Math.abs(dx1) < Math.abs(dx);
                if (dx > 0 && dy > 0 && dx1 > 0 && dy1 > 0 && less) {
                    return false;
                }
                if (dx > 0 && dy < 0 && dx1 > 0 && dy1 < 0 && less) {
                    return false;
                }
                if (dx < 0 && dy > 0 && dx1 < 0 && dy1 > 0 && less) {
                    return false;
                }
                if (dx < 0 && dy < 0 && dx1 < 0 && dy1 < 0 && less) {
                    return false;
                }
            }*/
            return true;
        }

        public boolean attacks() {
            return onTheSameRow() || onTheSameColumn() || onTheDiagonal();
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "queen1=" + queen1 +
                    ", queen2=" + queen2 +
                    '}';
        }
    }
}
