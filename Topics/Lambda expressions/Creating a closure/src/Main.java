import java.util.function.UnaryOperator;

class PrefixSuffixOperator {

    public static final String PREFIX = "__pref__";
    public static final String SUFFIX = "__suff__";

    public static UnaryOperator<String> operator = s -> PREFIX + s.trim() + SUFFIX;
}

class Testus {
    public static void main(String[] args) {
        System.out.println(PrefixSuffixOperator.operator.apply("    Это просто строка с пробелами         "));
        System.out.println(PrefixSuffixOperator.operator.apply("\t    Тут еще и табуляция с переводом строки \t  \n"));
    }
}