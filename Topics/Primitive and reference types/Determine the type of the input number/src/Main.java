import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            String result = (n > 0) ? "positive" : (n < 0) ? "negative" : "zero";
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("non-integer");
        }
        sc.close();
    }
}