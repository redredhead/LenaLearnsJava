package com.epam.elena_paveleva.java.lesson1.task1;

public class ArrayService { //this is a class with some routine methods
    void printArray(String text, int[] arr) {
        System.out.println(text);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    double getAverage(int[] arr) { // get average of the array
        int a = getSum(arr);
        double b = (double)getSum(arr) / (double)arr.length;
        return (b);
    }

    int getMinValue(int[] arr) {                                                                                                  // find minimum value in the array
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    void getDifference (int[] arr) { //get difference between array average and array min value
        System.out.println("Difference between array average and array min value is: " + (getAverage(arr) - getMinValue(arr)));
    }
}
