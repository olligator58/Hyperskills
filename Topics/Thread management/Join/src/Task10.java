import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task10 {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119186415.txt";

    public static void main(String[] args) {
        List<String> drummers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(",");
                if (line.length < 10) {
                    continue;
                }
                StringBuilder builder = new StringBuilder();
                for (String s : line) {
                    builder.append(s);
                }
                drummers.add(builder.toString());
            }
            Set<String> result = new HashSet<>();
            for (int i = 1; i < drummers.size(); i++) {
                Set<String> sequences = findLongestCommonSubstrings(drummers.get(0), drummers.get(i));
                for (String sequence : sequences) {
                    if (isSequenceInAllDrummers(drummers, sequence)) {
                        result.add(sequence);
                    }
                }
            }
            System.out.printf("The longest contiguous sequences that appears in all 10 drummers' patterns are: %s%n",
                    result);
            System.out.printf("The length of the longest contiguous sequence that appears in all 10 drummers' patterns is: %d%n",
                    new ArrayList<>(result).get(0).length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSequenceInAllDrummers(List<String> drummers, String sequence) {
        for (String drummer : drummers) {
            if (!drummer.contains(sequence)) {
                return false;
            }
        }
        return true;
    }

    private static Set<String> findLongestCommonSubstrings(String s, String t) {
        Set<String> substrings = new HashSet<>();
        int[][] lengths = new int[s.length()][t.length()];
        int z = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.substring(i, i + 1).equals(t.substring(j, j + 1))) {
                    if (i == 0 || j == 0) {
                        lengths[i][j] = 1;
                    } else {
                        lengths[i][j] = lengths[i - 1][j - 1] + 1;
                    }
                    if (lengths[i][j] > z) {
                        z = lengths[i][j];
                        substrings.clear();
                        substrings.add(s.substring(i - z + 1, i + 1));
                    } else if (lengths[i][j] == z) {
                        substrings.add(s.substring(i - z + 1, i + 1));
                    }
                } else {
                    lengths[i][j] = 0;
                }
            }
        }
        return substrings;
    }
}
