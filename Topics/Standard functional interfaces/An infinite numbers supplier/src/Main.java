import java.util.Scanner;
import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<>() {
            private int counter = 0;

            @Override
            public Integer get() {
                return counter++;
            }
        };
    }
}

class Tesus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Supplier<Integer> sup = FunctionUtils.getInfiniteRange() ;
        for (int i = 0; i < n; i++) {
            System.out.print(sup.get() + " ");
        }

        System.out.println();

        Supplier<Integer> sup1 = FunctionUtils.getInfiniteRange();
        Supplier<Integer> sup2 = FunctionUtils.getInfiniteRange();

        for(int i = 0; i < n; i++) {
            System.out.print(sup1.get() + " " + sup2.get() + " ");
        }
        scanner.close();
    }
}