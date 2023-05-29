package com.codegym.collection.basic;

import java.util.Comparator;

public class ComparatorDesc implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1.compareTo(o2) > 0) {
            return -1;
        } else if (o1.compareTo(o2)==0) {
            return 0;
        }else {
            return 1;
        }
    }
}

