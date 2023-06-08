package com.codegym.lamda.c10list;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /**
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(2);
        Function f = new MyMapImpl();
        List<Integer> a = (List<Integer>) list.stream().map(f).collect(Collectors.toList());


        List<Integer> b  = list.stream().map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 3;
            }
        }).collect(Collectors.toList());


        List<Integer> c = list.stream().map((integer) -> integer * 4).collect(Collectors.toList());
        System.out.println("End");

//        Comparator comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return (o1 -o1 > 0) ? 1 : (o1 - o2 == 0) ? 0 : -1;
//            }
//        };
        Integer max = (Integer) list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 -o1 > 0) ? 1 : (o1 - o2 == 0) ? 0 : -1;
            }
        }).get();

        Integer max1 = (Integer) list.stream().max((o1,o2)  -> (o1 -o2 > 0) ? 1 : (o1 - o2 == 0) ? 0 : -1 ).get();
//        System.out.println(max1);

        Integer max2 = list.stream().max(Math2::sosanh).get();
        System.out.println(max2);

        ToanHoc toanHoc = new ToanHoc();
        Integer max3 = list.stream().max(toanHoc::sosanh2So).get();

         **/

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(2);


    }
}