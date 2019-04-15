package com.epam.elena_paveleva.java.lesson1.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringService {
    static void findMinMax(Scanner sc) {
        System.out.println("Enter several lines. Enter E when finished");
        String min = null;
        String max = null;
        sc.useDelimiter("\n");
        String input = sc.next();
        while (!input.equalsIgnoreCase("e")) {
            if (min == null || input.length() < min.length()) {
                min = input;
            }
            if (max == null || input.length() > max.length()) {
                max = input;
            }
            input = sc.next();
        }
        System.out.println("min string is: " + min + " " + min.length());
        System.out.println("max string is: " + max + " " + max.length());
    }

    static double getAverageLength(String[] str) {
        double average = 0;
        for (int i = 0; i < str.length; i++) {
            average += str[i].length();
        }
        return average / str.length;
    }

    static void printLonger(String[] str) {
        double average = getAverageLength(str);
        System.out.println("Lines that are longer than average:");
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > average) {
                System.out.println(str[i]);
            }
        }
    }

    static void printShorter(String[] str) {
        double average = getAverageLength(str);
        System.out.println("Lines that are shorter than average:");
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() < average) {
                System.out.println(str[i]);
            }
        }
    }

    static String[] enterStrings(Scanner sc) {
        sc.useDelimiter("\n");
        System.out.println("Enter N and press Enter");
        int n;
        String[] str;
        try {
            n = sc.nextInt();
            System.out.println("Enter " + n + " lines");
            str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = sc.next();
            }
            return str;
        } catch (InputMismatchException e) {
            System.out.println("N must be an integer number");
            return null;
        }
    }
}
