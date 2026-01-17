import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


class FutureUtils {

    public static int executeCallableObjects(List<Future<Callable<Integer>>> items) {
        int counter = 0;
        List<Future<Callable<Integer>>> futures = new ArrayList<>(items);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = items.size() - 1; i >= 0; i--) {
            try {
                Callable<Integer> callable = futures.get(i).get();
                Future<Integer> future = executor.submit(callable);
                counter += future.get();
            } catch (InterruptedException | ExecutionException e) {
            }

        }
        executor.shutdown();
        return counter;
    }

}