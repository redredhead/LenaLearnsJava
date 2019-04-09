package com.epam.elena_paveleva.java.lesson1.task1;

import java.util.Scanner;

public class StringService {
    void findMinMax(Scanner sc) {
        System.out.println("Enter several lines. Enter E when finished");
        String min = null;
        String max = null;
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
}
