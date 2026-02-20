import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int index = 0;
            while (index < line.length()) {
                index = line.indexOf("<", index);
                if (line.charAt(index + 1) != '/') {
                    index = line.indexOf(">", index) + 1;
                    stack.push(index);
                    continue;
                }
                if (line.charAt(index + 1) == '/') {
                    int start = stack.pop();
                    System.out.println(line.substring(start, index));
                    index = line.indexOf(">", index) + 1;
                }
            }
        }
    }
}