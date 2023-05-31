package com.codegym.stack_queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyStack {
    private Integer arr[];
    private int size;
    private int index = 0;

    public MyStack(int size) {
        this.size = size;
        arr = new Integer[size];
    }

    public void push(int value) {
        if (index == arr.length) {
            arr  = Arrays.copyOf(arr, size*2);
        }
        arr[index] = value;
        index++;
    }
    public Integer pop() {
        int temp = arr[index - 1];
        arr[index-1] = null;
        index--;

        return temp;
    }
    public Integer peek() {
        return arr[index - 1];
    }
    public boolean isEmpty() {
        return index==0;
    }

    public static void main(String[] args) {
        // Về chuyển cái Stack này thành Generic

        MyStack stack = new MyStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(6);
        stack.push(9);

        stack.push(10);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
