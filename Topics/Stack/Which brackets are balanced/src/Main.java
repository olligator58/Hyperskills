import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('}', '{');
        brackets.put(')', '(');
        brackets.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        boolean result = true;
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            for (Character c : line.toCharArray()) {
                if (brackets.values().contains(c)) {
                    stack.push(c);
                    continue;
                }
                if (brackets.keySet().contains(c)) {
                    Character openingBracket = stack.pollFirst();
                    if (openingBracket == null || !openingBracket.equals(brackets.get(c))) {
                        result = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                result = false;
            }
            System.out.println(result);
        }
    }
}