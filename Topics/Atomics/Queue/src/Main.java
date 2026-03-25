import java.util.concurrent.atomic.AtomicReferenceArray;

class Queue {

    AtomicReferenceArray<Object> queue;

    public Queue(AtomicReferenceArray<Object> queue) {
        this.queue = queue;
    }

    public boolean enqueue(Object item) {
        //Write your code here
    }   
}