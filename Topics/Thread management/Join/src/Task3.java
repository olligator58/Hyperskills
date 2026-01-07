import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    private static final String FILE_NAME = "C:\\Temp\\flud\\hyperskill-dataset-119077014.txt";
    private static final String SPECIAL_SYMBOLS = "!@#$%^&*";

    public static void main(String[] args) {
        List<String> passwords = new ArrayList<>();
        Map<String, Double> securities = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.isEmpty()) {
                    passwords.add(line);
                }
            }

            for (String password : passwords) {
                // first rule
                double level = password.length();
                // second rule
                if (!hasLowerCaseLetter(password)) {
                    level *= 0.75d;
                }
                if (!hasUpperCaseLetter(password)) {
                    level *= 0.75d;
                }
                if (!hasDigit(password)) {
                    level *= 0.75d;
                }
                if (!hasSpecialSymbol(password)) {
                    level *= 0.75d;
                }
                //third rule
                if (NumberOfRepeats(password) > 0) {
                    level -= NumberOfRepeats(password);
                }
                securities.put(password, level);
            }

            List<Map.Entry<String, Double>> result = securities.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());
            Double maxSecurity = result.get(result.size() - 1).getValue();
            System.out.println(result);
            for (String password : passwords) {
                if (securities.get(password).compareTo(maxSecurity) == 0) {
                    System.out.printf("A password with the highest security score is: %s%n", password);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasLowerCaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasUpperCaseLetter(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialSymbol(String password) {
        for (char c : SPECIAL_SYMBOLS.toCharArray()) {
            if (password.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    private static int NumberOfRepeats(String password) {
        int maxRepeats = 0;
        for (char c : password.toCharArray()) {
            List<Character> chars = password.chars()
                    .mapToObj(c1 -> (char) c1)
                    .filter(c1 -> c1.equals(c))
                    .collect(Collectors.toList());
            if (chars.size() > maxRepeats) {
                maxRepeats = chars.size();
            }
        }
        return ((double) maxRepeats / password.length() > 0.3d) ? maxRepeats : 0;
    }
}
