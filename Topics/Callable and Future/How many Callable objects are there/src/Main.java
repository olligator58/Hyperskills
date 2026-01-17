import java.util.concurrent.Callable;


class FutureUtils {

    public static int determineCallableDepth(Callable callable) throws Exception {
        int counter = 1;
        while (true) {
            Object current = callable.call();
            if (!(current instanceof Callable)) {
                break;
            }
            counter++;
            callable = (Callable) current;
        }
        return counter;
    }

}

class Testus {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable1 = () -> 42;
        Callable<Callable<Callable<Callable<Integer>>>> callable4 = () -> (Callable<Callable<Callable<Integer>>>) () -> () -> () -> 42;
        System.out.println(FutureUtils.determineCallableDepth(callable1) == 1);
        System.out.println(FutureUtils.determineCallableDepth(callable4) == 4);
    }
}