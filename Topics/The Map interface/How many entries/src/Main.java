import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static void log(Map<Long, String> map) {
        String answer = (map.isEmpty()) ? "There are no objects" : (map.size() == 1) ? "Something in the map" :
                "Too many objects";
        System.out.println(answer);
    }

    // do not change the code below
    public static void main(String[] args) {
        String valueBase = "value-";
        Scanner scanner = new Scanner(System.in);

        Map<Long, String> m = new HashMap<>();
        long size = scanner.nextLong();
        for (long i = 0; i < size; ++i) {
            Long key = i;
            String value = valueBase + i;
            m.put(key, value);
        }
        log(Map.copyOf(m));
    }
}