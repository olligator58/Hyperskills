// You can experiment here, it won’t be checked

import java.util.List;

public class Task {
    public static void main(String[] args) {
      List<String> words = List.of("Huy", "hUy", "HuY", "PIZDA", "pIzDa");
      String targetWord = "huy";
      System.out.println(words.stream()
              .filter(w -> w.equalsIgnoreCase(targetWord))
              .map(w -> 1L)
              .reduce(0L, (count, next) -> count + 1));
    }
}
