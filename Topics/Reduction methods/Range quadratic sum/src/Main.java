import java.util.stream.IntStream;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        return IntStream.range(fromIncl, toExcl)
                .reduce(0, (sum, i) -> sum + i * i);
    }
}

class Testus {
    public static void main(String[] args) {
        System.out.println(QuadraticSum.rangeQuadraticSum(10, 12));
        System.out.println(QuadraticSum.rangeQuadraticSum(5, 6));
        System.out.println(QuadraticSum.rangeQuadraticSum(3, 3));
    }
}