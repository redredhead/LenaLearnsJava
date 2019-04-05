package com.epam.elena_paveleva.java.lesson1.task1;

public class ArrayTask1_2 {
    void sumEvenPositions (int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i+=2){
            sum+=arr[i];
        }
        System.out.println("Sum of elements on even positions: " + sum);
    }
}
