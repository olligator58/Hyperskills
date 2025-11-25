public class Main {
    public static void main(String[] args) {
        String name = "Lazy";
        String status = "detected";
        int errorCode = 2;

        String formattedMessage = String.format("%s employee %s! Error code: %d", name, status, errorCode);
        System.out.printf("Result of work - %s", formattedMessage);
    }
}