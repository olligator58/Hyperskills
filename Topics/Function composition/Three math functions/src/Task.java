// You can experiment here, it won’t be checked

import java.util.function.Consumer;
import java.util.function.Function;

public class Task {
    public static void main(String[] args) {
        Function<Double, Double> f = x -> x + 5;

        Function<Double, Double> g = x -> x - 7;

        Function<Double, Double> h = x -> x * 2;


        Function<Double, Double> composed = f.andThen(g).compose(h);

        System.out.println(composed.apply(9.0));

        Function<String, String> operator1 = s -> s + s;
        Function<String, String> operator2 = s -> String.valueOf(s.length());
        Function<String, String> resultOperator = operator1.compose(operator2);

        System.out.println(resultOperator.apply("test"));

        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> devNull = (val) -> { int v = val * 2; };

        Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
        combinedConsumer.accept(100);
    }
}
