import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        System.out.println(str.substring(i1, i2 + 1));
        scanner.close();
    }
}