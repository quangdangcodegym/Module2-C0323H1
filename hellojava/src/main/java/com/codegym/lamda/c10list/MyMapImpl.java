package com.codegym.lamda.c10list;

import java.util.function.Function;

public class MyMapImpl implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer a) {
        return a*2;
    }
}
