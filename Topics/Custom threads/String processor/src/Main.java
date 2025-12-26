import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            String line = scanner.nextLine();
            if (!containsLowerCaseCharacter(line)) {
                System.out.println("FINISHED");
                break;
            }
            System.out.println(line.toUpperCase());
        }
    }

    private boolean containsLowerCaseCharacter(String line) {
        for (char c : line.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }
}

class Testus {
    public static void main(String[] args) {
        StringProcessor stringProcessor = new StringProcessor();
        stringProcessor.start();
    }
}