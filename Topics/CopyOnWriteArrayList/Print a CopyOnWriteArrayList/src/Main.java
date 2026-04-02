import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

class PrintElementsClass {

    public static void printElements(CopyOnWriteArrayList<String> onWriteArrayList, String elementToAdd) {
        onWriteArrayList.add(elementToAdd);
        Iterator<String> iterator = onWriteArrayList.iterator();
        StringBuilder str = new StringBuilder();

        while (iterator.hasNext()) {
            str.append(String.format("%s ", iterator.next()));
        }
        System.out.println(str.toString().trim());
    }
}

class Testus {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(List.of("first", "second", "third"));
        PrintElementsClass.printElements(list, "last");
    }
}