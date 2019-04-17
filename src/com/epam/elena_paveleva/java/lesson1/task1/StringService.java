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
        if (min != null && max != null) {
            System.out.println("min string is: " + min + " with length: " + min.length());
            System.out.println("max string is: " + max + " with length: " + max.length());
        } else {
            System.out.println("Incorrect input value");
        }
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
        int n = getN(sc);
        sc.useDelimiter("\n");
        String[] str = new String[n];
        System.out.println("Enter " + n + " lines");
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        return str;
    }

    static String[] enterWords(Scanner sc) {
        int n = getN(sc);
        String[] words = new String[n];
        sc.useDelimiter("\\s");
        System.out.println("Enter " + n + " words separated by space");
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        return words;
    }

    static int getN(Scanner sc) {
        sc.useDelimiter("\n");
        int n;
        while (true) {
            System.out.println("Enter N and press Enter");
            try {
                n = sc.nextInt();
                return n;
            } catch (InputMismatchException e) {
                System.out.println("N must be an integer number");
                sc.next();
            }
        }
    }

    static int countSymbols(String str) {
        int c = 0;
        str = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            boolean isUnique = true;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    isUnique = false;
                }
            }
            if (isUnique == true) {
                c++;
            }
        }
        return c;
    }

    static void findWordWithMinSymbols(String[] words) {
        String minWord = words[0];
        for (int i = 0; i < words.length; i++) {
            if (countSymbols(words[i]) < countSymbols(minWord)) {
                minWord = words[i];
            }
        }
        System.out.println("Word with min amount of different symbols is: " + minWord);
    }

    static void findWordWithUniqueSymbolsOnly(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (countSymbols(words[i]) == words[i].length()) {
                System.out.println("Word with unique symbols only: " + words[i]);
                return;
            }
            if (i == (words.length - 1)) {
                System.out.println("Word with unique symbols only is not found");
                return;
            }
        }
    }
}
