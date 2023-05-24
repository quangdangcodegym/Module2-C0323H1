package com.codegym.comparable;


import java.util.Comparator;

public class ComparatorByArea implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if (o1.getArea() > o2.getArea()) {
            return 1;
        } else if (o1.getArea() == o2.getArea()) {
            return 0;
        }
        return -1;
    }
}
