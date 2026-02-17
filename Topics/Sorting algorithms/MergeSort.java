package ru.bis.cc;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {15, 10, 20, 19, 67, 30, 100, 24, 45};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        mergeInPlace(array, left, right, middle);
    }

    private static void merge(int[] array, int left, int right, int middle) {
        int[] leftPart = new int[middle - left + 1];
        int[] rightPart = new int[right - middle];

        for (int i = 0; i < leftPart.length; i++) {
            leftPart[i] = array[left + i];
        }

        for (int i = 0; i < rightPart.length; i++) {
            rightPart[i] = array[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                array[k] = leftPart[i];
                i++;
            } else {
                array[k] = rightPart[j];
                j++;
            }
            k++;
        }

        while (i < leftPart.length) {
            array[k] = leftPart[i];
            i++;
            k++;
        }

        while (j < rightPart.length) {
            array[k] = rightPart[j];
            j++;
            k++;
        }
    }

    private static void mergeInPlace(int[] array, int left, int right, int middle) {
        int i = left;
        int j = middle + 1;

        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                i++;
            } else {
                int tmp = array[j];
                int k = j;
                while (k > i) {
                    array[k] = array[k - 1];
                    k--;
                }
                array[i] = tmp;
                i++;
                j++;
                middle++;
            }
        }
    }
}
