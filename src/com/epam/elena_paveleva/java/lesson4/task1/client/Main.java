package com.epam.elena_paveleva.java.lesson4.task1.client;

import com.epam.elena_paveleva.java.lesson4.task1.impl.DynamicArray;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        Set<Integer> set = IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toSet());
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        set.stream().parallel().unordered().forEach(list::add);
        System.out.println("All elements unique: " + list.stream().allMatch(new HashSet<>()::add));
        System.out.println("Min element: " + list.stream().min(Integer::compare).get());
        list = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println("2nd max: " + list.stream().sorted().skip(list.size() - 2).findAny().get());
    }
}
