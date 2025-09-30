class ArraySorting {
    /**
     * @param array unordered sequence of strings
     * @return ordered array of strings
     */
    public static String[] sortArray(String[] array) {
        java.util.Arrays.sort(array);
        return array;
    }
}

class Test {
    public static void main(String[] args) {
        String[] words = {"y",  "d",  "b",  "u",  "t",  "f", "m", "h", "x", "q"};
        System.out.println(java.util.Arrays.toString(ArraySorting.sortArray(words)));
    }
}