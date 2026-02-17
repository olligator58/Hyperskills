package ru.bis.cc;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {15, 10, 20, 19, 67, 30, 100, 24, 45};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int x = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > x) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = x;
        }
    }
}
