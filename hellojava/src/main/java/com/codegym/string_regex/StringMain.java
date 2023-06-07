package com.codegym.string_regex;

public class StringMain {
    public static void main(String[] args) {
        String b = "Dang Van Quang";
        String b5 = "Vo    Duy      Hung";
        String [] items = b5.split(" +");


        String a1 = "Quang Dang";
        String a2 = "Thien Nhan";
        int num = a1.compareTo(a2);
        System.out.println("Num: " + num);
        System.out.println(a1.startsWith("Quang"));

        // Dang Van Quang;
        StringBuilder b1 = new StringBuilder("Dang"); // ['D','a','n', 'g']
        b1.append(" Quang");    // [Dang Quang]
//        b1.insert(4, "Van");
        b1.insert(5, "Van ");

        System.out.println(b1);
    }
}
