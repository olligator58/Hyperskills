import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String substr = scanner.nextLine();

        int counter = 0;
        int index;
        while ((index = line.indexOf(substr)) >= 0) {
            counter++;
            line = line.substring(index + substr.length());
        }
        System.out.println(counter);
        scanner.close();
    }
}