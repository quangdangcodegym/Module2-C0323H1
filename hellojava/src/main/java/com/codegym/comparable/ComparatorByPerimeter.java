package com.codegym.comparable;

import java.util.Comparator;

public class ComparatorByPerimeter implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if (o1.getPerimeter() > o2.getPerimeter()) {
            return 1;
        } else if (o1.getPerimeter() == o2.getPerimeter()) {
            return 0;
        }
        return -1;
    }
}
