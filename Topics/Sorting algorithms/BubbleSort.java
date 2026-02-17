package ru.bis.cc;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {15, 10, 20, 19, 67, 30, 100, 24, 45};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        boolean swapped = true;
        int j = array.length;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < j; i++) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                    swapped = true;
                }
            }
            j--;
        }
    }
}
