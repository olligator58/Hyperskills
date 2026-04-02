import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

class QueueUtils {
    public static int getLastNumber(Queue<Integer> target) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>(target);
        Integer[] numbers = queue.toArray(new Integer[0]);
        return (numbers.length > 0) ?  numbers[numbers.length - 1] : 0;
    }
}

class Testus {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(List.of(1, 3, 2, 5, 4, 7, 6, 9, 8));
        System.out.println(queue);
        System.out.println(QueueUtils.getLastNumber(queue));
    }
}