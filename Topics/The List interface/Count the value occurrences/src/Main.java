import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        int counter1 = 0;
        int counter2 = 0;

        for (Integer i : list1) {
            if (i == elem) {
                counter1++;
            }
        }

        for (Integer i : list2) {
            if (i == elem) {
                counter2++;
            }
        }
        return counter1 == counter2;
    }
}

class Testus {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(8, 8, 3, 3, 2);
        List<Integer> list2 = List.of(1, 3, 3, 2);
        System.out.println(Counter.checkTheSameNumberOfTimes(3, list1, list2));
        list1 = List.of(9, 8, 4, 3, 2);
        list2 = List.of(1, 3, 3, 3);
        System.out.println(Counter.checkTheSameNumberOfTimes(3, list1, list2));
    }

}