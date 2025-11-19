import java.util.*;

public class Main {
    static class Box<T> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println(new Box<>(num).getValue());
        } else if (sc.hasNextFloat()) {
            float num = sc.nextFloat();
            System.out.println(new Box<>(num).getValue());
        } else {
            String str = sc.next();
            System.out.println(new Box<>(str).getValue());
        }
    }
}