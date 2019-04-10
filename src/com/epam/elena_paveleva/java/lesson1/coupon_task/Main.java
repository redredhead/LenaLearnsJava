package com.epam.elena_paveleva.java.lesson1.coupon_task;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Coupon> coupons = new ArrayList<Coupon>();
        Coupon c1 = new Coupon(5);
        Coupon c2 = new Coupon(6);
        Coupon c3 = new Coupon(2);
        Coupon c4 = new Coupon(2);

        int orderValue = 8;

        coupons.add(c1);
        coupons.add(c2);
        coupons.add(c3);
        coupons.add(c4);

        Permutation p = new Permutation(coupons);
        System.out.println(Arrays.toString(p.findOptimum(orderValue)));




    }




}
