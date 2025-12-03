class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT = (a, b, c) -> a != b && b != c && a != c;

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int a, int b, int c);
    }
}

class Testus {
    public static void main(String[] args) {
        System.out.println(Predicate.ALL_DIFFERENT.test(1, 1, 1));
        System.out.println(Predicate.ALL_DIFFERENT.test(2, 1, 1));
        System.out.println(Predicate.ALL_DIFFERENT.test(1, 2, 1));
        System.out.println(Predicate.ALL_DIFFERENT.test(1, 1, 2));
        System.out.println(Predicate.ALL_DIFFERENT.test(2, 3, 4));
    }
}