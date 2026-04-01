import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class WishList {
    private ArrayList<Integer> products;
    private Semaphore semaphore = new Semaphore(1);

    public WishList() {
        this.products = new ArrayList<>();
    }

    public void addProduct(int product_id) {
        try {
            semaphore.acquire();
            products.add(product_id);
            semaphore.release();
        } catch (InterruptedException ignored) {
        }
    }

    public void removeProduct(int product_id) {
        try {
            semaphore.acquire();
            products.remove(Integer.valueOf(product_id));
            semaphore.release();
        } catch (InterruptedException ignored) {
        }
    }

    public int getSize() {
        return products.size();
    }

}

class Testus {
    public static void main(String[] args) throws InterruptedException {
        int numOfAdds = 10000;
        int numOfRemoves = 6000;
        WishList wishList = new WishList();
        Thread adder = new Thread(() -> {
            for (int i = 0; i < numOfAdds; i++) {
                wishList.addProduct(i* 2);
                System.out.println(Thread.currentThread().getName() + " added " + i * 2);
            }
        });
        Thread remover = new Thread(() -> {
            for (int i = 0; i < numOfRemoves; i++) {
                wishList.removeProduct(i * 2);
                System.out.println(Thread.currentThread().getName() + " removed " + i * 2);
            }
        });
        adder.start();
        adder.join();
        remover.start();
        remover.join();
        System.out.println(wishList.getSize());
    }
}