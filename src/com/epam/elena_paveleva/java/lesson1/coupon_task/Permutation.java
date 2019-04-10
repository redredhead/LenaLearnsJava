package com.epam.elena_paveleva.java.lesson1.coupon_task;

import java.util.ArrayList;

public class Permutation {
    int permutations[][];
    int qtyPermutations;
    String formatExpression;
    int[] optSelection;
    int optValue = 0;
    int[] values;

    Permutation(ArrayList<Coupon> coupons) {
        qtyPermutations = (int) Math.pow(2, coupons.size());
        permutations = new int[qtyPermutations][coupons.size()];
        formatExpression = "%0" + coupons.size() + "d";
        values = new int[coupons.size()];
        for (int i = 0; i < coupons.size(); i++) {
            values[i] = coupons.get(i).getValue();
        }

    }

    int[] charToIntArrayConverter(String s) {
        int[] a = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - '0';

        }
        return a;
    }

    int[] findOptimum(int orderTotal) {
        for (int i = 0; i < qtyPermutations; i++) {
            permutations[i] = charToIntArrayConverter((String.format(formatExpression, Integer.parseInt(Integer.toBinaryString(i)))));
            if (getSum(permutations[i]) > optValue && getSum(permutations[i]) <= orderTotal) {
                optSelection = permutations[i];
                optValue = getSum(permutations[i]);
            }
        }
        return optSelection;
    }

    int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (values[i] * arr[i]);
        }
        return sum;
    }

}
