package com.epam.elena_paveleva.java.lesson4.task1.client;

import com.epam.elena_paveleva.java.lesson4.task1.impl.CollectionService;
import com.epam.elena_paveleva.java.lesson4.task1.impl.DynamicArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynArr = new DynamicArray<>(3);
        dynArr.add(1);
        dynArr.add(3);
        dynArr.add(4);
        dynArr.add(7);
        System.out.println(dynArr.get(3));
        System.out.println(dynArr.toString());
        dynArr.remove(0);
        dynArr.remove(0);
        System.out.println(dynArr.toString());

        DynamicArray<String> dynArr2 = new DynamicArray<>(5);
        dynArr2.add("test2");
        dynArr2.add("test3");
        dynArr2.add("test4");
        dynArr2.remove(1);
        System.out.println(dynArr2.toString());

        //task2
        Integer[] arr = new Integer[1_000_000];
        CollectionService.generateArray(arr);
        ArrayList arrayList = new ArrayList<>(Arrays.asList(arr));
        Collections.shuffle(arrayList);
        System.out.println("All elements unique: " + CollectionService.isAllUnique(arrayList));
        System.out.println("Min element: " + Collections.min(arrayList));
        CollectionService.removeOddElements(arrayList);
        Collections.sort(arrayList);
        System.out.println("second min element: " + arrayList.get(arrayList.size() - 2));
    }
}
