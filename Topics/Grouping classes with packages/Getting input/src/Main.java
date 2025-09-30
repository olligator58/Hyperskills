class InputReader {
    public static String getString() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        return line;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("The input string: " + InputReader.getString());
    }
}