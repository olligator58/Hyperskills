import java.util.Scanner;

public class Main {
    public static String transformString(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                result[i] = (c + 1 <= 122) ? (char) (c + 1) : 'a';
            }
            if (Character.isDigit(c)) {
                result[i] = (c - 1 >= 48) ? (char) (c - 1) : '9';
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(transformString(s));
    }
}