import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamUtils {

    public static Stream<Integer> generateStreamWithPowersOfTwo(int n) {
        return Stream.iterate(1, i -> i * 2)
                .limit(n);


    }
}

class Testus {
    public static void main(String[] args) {
        String result = StreamUtils.generateStreamWithPowersOfTwo(10)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}