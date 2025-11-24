import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (left, right) -> {
        long product = left;
        for (long l = left + 1; l <= right ; l++) {
            product *= l;
        }
        return product;
    };
}

class Testus {
    public static void main(String[] args) {
        System.out.println(Operator.binaryOperator.applyAsLong(0, 1));
        System.out.println(Operator.binaryOperator.applyAsLong(2, 2));
        System.out.println(Operator.binaryOperator.applyAsLong(1, 4));
        System.out.println(Operator.binaryOperator.applyAsLong(5, 15));
    }
}