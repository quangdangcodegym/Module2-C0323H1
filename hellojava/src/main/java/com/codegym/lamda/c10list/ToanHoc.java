package com.codegym.lamda.c10list;

public class ToanHoc {
    public int sosanh2So(Integer a1, Integer a2) {
        if (a1.compareTo(a2) > 0) {
            return 1;
        } else if (a1.compareTo(a2) == 0) {
            return 0;
        }else {
            return -1;
        }
    }
}
