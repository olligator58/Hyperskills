import java.util.concurrent.atomic.AtomicBoolean;

class Flag {
    public boolean setFlag(AtomicBoolean flag) {
        return flag.compareAndSet(false, true);
    }
}

class Testus {
    public static void main(String[] args) {
        Flag flag = new Flag();
        AtomicBoolean initialFlag = new AtomicBoolean(false);
        System.out.println(flag.setFlag(initialFlag));
        System.out.println(flag.setFlag(initialFlag));
        System.out.println(flag.setFlag(initialFlag));
    }
}