class Counter {

    int current;

    public void inc() {
        this.current++;
    }

    public int getCurrent() {
        return this.current;
    }

}

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        System.out.println(counter.current);
        counter.inc();
        System.out.println(counter.getCurrent());
    }
}