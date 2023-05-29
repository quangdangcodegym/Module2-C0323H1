package com.codegym.collection.mylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size] = e;
        size++;
//        elements[size++] = e;
    }

    public int size() {
        return this.size;
    }
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }
        return (E) elements[index];
    }

    public void remove(int index) {

    }

    public void add(int index, E obj) {

    }
}
