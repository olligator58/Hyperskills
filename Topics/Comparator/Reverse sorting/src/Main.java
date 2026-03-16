import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Utils {

    public static void sortStrings(List<String> strings) {
        strings.sort(Comparator.reverseOrder());
    }
}

class Testus {
    public static void main(String[] args) {
        List<String> words1 = new ArrayList<>(List.of("apple", "grape", "pear", "banana", "pineapple"));
        Utils.sortStrings(words1);
        System.out.println(words1);
        List<String> words2 = new ArrayList<>(List.of("Cap", "cape", "cup", "cake", "Cook"));
        Utils.sortStrings(words2);
        System.out.println(words2);
    }
}