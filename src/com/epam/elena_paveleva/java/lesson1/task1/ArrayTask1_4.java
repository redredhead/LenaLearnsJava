package com.epam.elena_paveleva.java.lesson1.task1;

public class ArrayTask1_4 {
    int[] triplePositive(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > 0 && arr[i - 1] < 0) {
                arr[i]*=3;
            }
        }
        return arr;
    }
}
