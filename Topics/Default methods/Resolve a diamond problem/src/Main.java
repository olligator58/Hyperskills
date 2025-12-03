class ConsoleWriter implements Printer, Notifier {
    @Override
    public void greeting() {
        Printer.super.greeting();
    }
}

interface Printer {
    default void greeting() {
        System.out.println("Printer is ready");
    }
}

interface Notifier {
    default void greeting() {
        System.out.println("Notifier is ready");
    }
}

class Testus {
    public static void main(String[] args) {
        ConsoleWriter consoleWriter = new ConsoleWriter();
        consoleWriter.greeting();
    }
}