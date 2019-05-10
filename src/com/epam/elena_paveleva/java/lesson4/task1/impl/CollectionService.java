package com.epam.elena_paveleva.java.lesson4.task1.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CollectionService {
    public static void generateArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    public static boolean isAllUnique(List list) {
        HashSet<Object> hashSet = new HashSet<Object>(list);
        return hashSet.size() == list.size();
    }

    public static void removeOddElements(ArrayList<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) % 2 == 1) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }
}