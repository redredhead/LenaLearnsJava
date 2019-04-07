package com.epam.elena_paveleva.java.lesson1.task1;

public class ArrayService { //this is a class with some routine methods
    void printArray(String text, int[] arr) {
        System.out.println(text);
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
        System.out.print("\n");
    }

    int[] initializeArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 21) - 10;
        }
        return arr;
    }

    int getSum(int[] arr) {     //get sum of the elements in array
        int sum = 0;
        for (int i1 : arr) {
            sum += i1;
        }
        return sum;
    }

    double getAverage(int[] arr) { // Task 1_5 : get average of the array
        return ((double) getSum(arr) / (double) arr.length);
    }

    int getMinValue(int[] arr) {     // Task 1_5                                                                                             // find minimum value in the array
        int min = arr[0];
        for (int i1 : arr) {
            if (i1 < min) {
                min = i1;
            }
        }
        return min;
    }

    void calculateDifference(int[] arr) { //Task 1_5: get difference between array average and array min value
        System.out.println("Difference between array average and array min value is: " + (getAverage(arr) - getMinValue(arr)));
    }
}
