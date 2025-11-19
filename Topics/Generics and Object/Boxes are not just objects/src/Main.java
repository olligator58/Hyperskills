/**

Object-based box class that requires casting every time you want to get some specific stuff from it, e.g.:

    Box cakeBox = new Box();
    cakeBox.put(new Cake());
    // Without casting only object can be retrieved out of the box
    Cake cake = (Cake) cakeBox.get();

Casting is not desirable and can fall at runtime, could you create more... generic solution?

*/
class Box<T> {

    private T item;

    public void put(T item) {
    	this.item = item;
    }

    public T get() {
        return this.item;
    }

}

class Testus {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.put(10);
        System.out.println(integerBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.put("String box");
        System.out.println(stringBox.get());
    }
}