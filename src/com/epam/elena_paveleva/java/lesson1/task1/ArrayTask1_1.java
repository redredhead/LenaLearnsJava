package com.epam.elena_paveleva.java.lesson1.task1;

public class ArrayTask1_1 {
    int[] swapElements(int[] arr) {
        Integer minPositive = null;
        Integer maxNegative = null;


        for (int i1 : arr) {
            if (i1 > 0 && (minPositive == null || i1 < minPositive))
            {
                minPositive = i1;
            }
            if (i1 < 0 && (maxNegative == null || i1 > maxNegative)) {
                maxNegative = i1;
            }
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
