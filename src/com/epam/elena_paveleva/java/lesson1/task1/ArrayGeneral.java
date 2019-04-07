package com.epam.elena_paveleva.java.lesson1.task1;

import java.util.Scanner;

public class ArrayGeneral {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number of the task you want to run or press X for exit: ");

            if (sc.next().toUpperCase().equals("X")) {
                System.out.println("Bye");
                sc.close();
                return;
            } else if (sc.hasNextInt()) {
                int taskNumber = sc.nextInt();
                int[] arr;
                ArrayService arrayService = new ArrayService();
                switch (taskNumber) {

                    case 1: // task 1_1
                        arr = arrayService.initializeArray(20);
                        arrayService.printArray("Original array:", arr);
                        ArrayTask1_1 swapArray = new ArrayTask1_1();
                        arrayService.printArray("Array we deserved:", swapArray.swapElements(arr));
                        break;

                    case 2:// task 1_2
                        ArrayTask1_2 arrTask1_2 = new ArrayTask1_2();
                        arr = arrayService.initializeArray(20);
                        arrayService.printArray("\nArray for task 2: ", arr);
                        arrTask1_2.sumEvenPositions(arr);
                        break;

                    case 3:
                        System.out.println("Andrew told me to skip this task");
                        break;

                    case 4: //task 1_4
                        ArrayTask1_4 arrTask1_4 = new ArrayTask1_4();
                        arr = arrayService.initializeArray(20);
                        arrayService.printArray("\nOriginal array for task 4:", arr);
                        arrayService.printArray("\nMultiplied array: ", arrTask1_4.triplePositive(arr));
                        break;

                    case 5: //task 1_5
                        arr = arrayService.initializeArray(20);
                        arrayService.printArray("\nOriginal array for task 5:", arr);
                        arrayService.calculateDifference(arr);
                        break;

                    case 6:
                        arr = arrayService.initializeArray(20);
                        arrayService.printArray("\nOriginal array for task 5:", arr);
                        ArrayTask1_6 arrTask1_6 = new ArrayTask1_6(arr);
                        arrTask1_6.countOccurrences();
                        arrTask1_6.printDuplicates();
                        break;

                    default:
                        System.out.println("There's no such task yet");
                        break;
                }
            } else {
                System.out.println("Input is not an index number");
            }
        }
    }
}
