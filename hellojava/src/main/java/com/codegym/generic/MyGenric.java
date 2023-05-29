package com.codegym.generic;

public class MyGenric<T> {
    T obj;

    public void add(T obj) {
        this.obj = obj;
    }
    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        MyGenric<String> myGenric = new MyGenric<>();
    }
}
