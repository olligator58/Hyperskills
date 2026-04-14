// You can experiment here, it won’t be checked

import java.util.List;

public class Task {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(3, 5, 4, 8, 9, 2);
    numbers.parallelStream().sorted().sequential().forEach(System.out::println);
  }
}
