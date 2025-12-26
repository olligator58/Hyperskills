class Info {

    public static void printCurrentThreadInfo() {
        Thread currentThread = Thread.currentThread();
        System.out.printf("name: %s%n", currentThread.getName());
        System.out.printf("priority: %d%n", currentThread.getPriority());
    }
}

class Testus {
    public static void main(String[] args) {
        Info.printCurrentThreadInfo();
    }
}