import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                stack.push(scanner.nextInt());
            }
            while (stack.peek() != null) {
                System.out.println(stack.pop());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}