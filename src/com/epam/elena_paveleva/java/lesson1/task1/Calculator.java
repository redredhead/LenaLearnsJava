package com.epam.elena_paveleva.java.lesson1.task1;

public class Calculator {
    static void getAnswer(String str) {
        int[] values = new int[2];
        for (int i = 0; i < 2; i++) {
            try {
                values[i] = Integer.parseInt(str.split("[-+*/]")[i]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input");
                return;
            }
        }

        switch (getAction(str)) {

            case '+':
                System.out.println(str + "= " + (values[0] + values[1]));
                break;

            case '-':
                System.out.println(str + "= " + (values[0] - values[1]));
                break;

            case '*':
                System.out.println(str + "= " + (values[0] * values[1]));
                break;

            case '/':
                if (values[1] == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println(str + "= " + ((double) values[0] / (double) values[1]));

                }
                break;

            default:
                System.out.println("Invalid input");
        }
    }

    static char getAction(String str) {
        char action = 'x';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                action = str.charAt(i);
                return action;
            }
        }
        return action;
    }

    static String[] getValues(String str) {
        return str.split("[-+*/]");
    }
}
