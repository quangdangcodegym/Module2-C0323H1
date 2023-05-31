package com.codegym.stack_queue;

import java.util.*;

public class IteratorMain {
    public static void main(String[] args) {
//        int[] numbers = {5, 1, 2, 7, 8};
//        reverseArray(numbers);
//        System.out.println(Arrays.toString(numbers));
        chuyensosangnhiphan(14);




    }
    public static String chuyensosangnhiphan(int number){
        String str = "";
        Stack<Integer> stack = new Stack<>();
        while (number != 0)
        {
            stack.push(number % 2);
            number = number / 2;
        }
        while (!stack.empty()){
            str += stack.pop();
        }
        return str;
    }
    public static void reverseArray(int[] numbers) {
        Stack<Integer> stack =new Stack<>();
        for(int i = 0; i < numbers.length; i++){
            stack.push(numbers[i]);
        }
        int i =0;

//        System.out.println("Duyệt bang stack.empty");
        while (!stack.empty()) {
            numbers[i] = stack.pop();
            i++;
        }
//        System.out.println(Arrays.toString(numbers));
    }
    public void basicIterator() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(5);
        list.add(1);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void basicPushPopStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(8);
        stack.push(3);
        stack.push(8);

        stack.pop();
        stack.peek();
        stack.peek();
        stack.pop();
    }

    public void travelStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(8);
        stack.push(3);
        stack.push(8);

        System.out.println("Duyệt bang iterator");
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Duyệt bằng for : ");
        for (Integer item : stack) {
            System.out.println(item);
        }

        System.out.println("Duyệt bang stack.empty");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public void distinguishPollRemovePeekElement() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(5);

        queue.peek();
        queue.element();

        queue.poll();
        queue.remove();
    }
}
