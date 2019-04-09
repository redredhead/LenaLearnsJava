package com.epam.elena_paveleva.java.lesson1.task1;

public class ArrayTask1_6 {
    private int[][] frequencyArray;

    ArrayTask1_6(int[] arr) {
        frequencyArray = new int[2][arr.length];
        frequencyArray[0] = arr;
    }

    void countOccurrences() {
        for (int i = 0; i < frequencyArray[0].length; i++) {
            for (int j = 0; j < i; j++) {
                if (frequencyArray[0][j] == frequencyArray[0][i]) {
                    frequencyArray[1][j]++;
                    frequencyArray[1][i]++;
                }
            }
        }
    }

    void printOddDuplicates() {
        System.out.println("Duplicates with odd index:");
        for (int i = 1; i < frequencyArray[0].length; i+=2) {
            if (frequencyArray[1][i] > 0) {
                System.out.print(frequencyArray[0][i] + " ");
            }
        }
        System.out.print("\n");
    }
}
