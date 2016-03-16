package com.simplicityitself.training.bench;

import java.util.concurrent.RecursiveAction;

/**
 * Created by Thalita on 16/03/16.
 * Extend RecursiveAction because I don't need the task to return a result
 * (it modifies the array in place)
 */
public class ForkedJavaQuickSort extends RecursiveAction {
    private int[] numbers;
    private int start;
    private int end;

    /**
     * Static method called by the outside class
     */
    public static void quickSort(int[] numbers) {
        new ForkedJavaQuickSort(numbers, 0, numbers.length - 1).compute();
    }

    /**
     * Constructor to capture the array, the start and the end
     */
    private ForkedJavaQuickSort(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    /**
     * Implementation of recursive method from RecursiveAction
     * Divides the task and processes them in separate threads
     */
    protected void compute() {
        if (start < end) {
            int q = partition(numbers, start, end);
            invokeAll(new ForkedJavaQuickSort(numbers, start, q), new ForkedJavaQuickSort(numbers, q + 1, end));
        }
    }

    private static int partition(int[] a, int p, int r) {

        int x = a[p];
        int i = p - 1;
        int j = r + 1;

        while (true) {
            i++;
            while (i < r && a[i] < x)
                i++;
            j--;
            while (j > p && a[j] > x)
                j--;

            if (i < j)
                swap(a, i, j);
            else
                return j;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
