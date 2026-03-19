import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String answer = (password.matches(".{12,}") && password.matches(".*[A-Z].*") &&
                         password.matches(".*[a-z].*") && password.matches(".*\\d.*")) ? "YES" : "NO";
        System.out.println(answer);
        scanner.close();
    }
}