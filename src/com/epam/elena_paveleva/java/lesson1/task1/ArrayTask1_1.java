package com.epam.elena_paveleva.java.lesson1.task1;

public class ArrayTask1_1 {
    int[] swapElements(int[] arr) {
        Integer minPositive = null;
        Integer maxNegative = null;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && ( minPositive == null || arr[i] < minPositive )) minPositive = arr[i];
            if (arr[i] < 0 && ( maxNegative == null || arr[i] > maxNegative )) maxNegative = arr[i];
        }


        if (minPositive != null && maxNegative != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == minPositive) {
                    arr[i] = maxNegative;
                } else if (arr[i] == maxNegative) {
                    arr[i] = minPositive;
                }
            }
        }
        return arr;
    }
}
