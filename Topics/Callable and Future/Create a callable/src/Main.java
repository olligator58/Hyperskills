import java.util.Scanner;
import java.util.concurrent.Callable;

class CallableUtil {
    public static Callable<String> getCallable() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        scanner.close();
        return () -> value;
    }
}

class Testus {
    public static void main(String[] args) throws Exception {
        System.out.println(CallableUtil.getCallable().call());
    }
}
