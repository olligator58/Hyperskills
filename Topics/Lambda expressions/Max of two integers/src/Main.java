import java.util.function.IntBinaryOperator;

class Operator {

    public static IntBinaryOperator binaryOperator = (x, y) -> (x >= y) ? x : y;
}

class Testus {
    public static void main(String[] args) {
        System.out.println(Operator.binaryOperator.applyAsInt(3, 5));
        System.out.println(Operator.binaryOperator.applyAsInt(123, -9));
        System.out.println(Operator.binaryOperator.applyAsInt(5, 5));
    }
}