package com.codegym.collection.basic;

import java.util.*;

public class CollectionBuoi1 {
    public static void main(String[] args) {
        /**
         // dùng hashset thì: danh sách không trùng lặp
         Set<Integer> sets1 = new HashSet<>();
         sets1.add(5);
         sets1.add(7);
         sets1.add(5);       // trung lap roi
         sets1.add(3);
         sets1.add(1);
         sets1.add(-5);

         for (Integer item : sets1) {
         System.out.println(item);
         }

         // dùng treeset thì: danh sách được sắp xếp và không trùng lặp
         Set<Integer> sets1 = new TreeSet<>();
         sets1.add(5);
         sets1.add(7);
         sets1.add(5);       // trung lap roi
         sets1.add(3);
         sets1.add(1);
         sets1.add(-5);

         for (Integer item : sets1) {
         System.out.println(item);
         }

         // Tạo ra danh sách được sắp xếp giảm dần
         Set<Integer> sets1 = new TreeSet<>(new Comparator<Integer>() {
        @Override public int compare(Integer o1, Integer o2) {
        if (o1.compareTo(o2) > 0) {
        return -1;
        } else if (o1.compareTo(o2)==0) {
        return 0;
        }else {
        return 1;
        }
        }
        });
         sets1.add(5);
         sets1.add(7);
         sets1.add(5);       // trung lap roi
         sets1.add(3);
         sets1.add(1);
         sets1.add(-5);
         for (Integer item : sets1) {
         System.out.println(item);
         }

         // Phân biệt list: dung for int i, Set: dung for :
         // Tuyệt chiêu biết 1 phương thức từ lớp nào mà ra
         List<String> ds = new ArrayList<>();
         ds.add("Quang");
         ds.add("Minh");
         ds.add("Hung");
         ds.add("Quang");
         for (int i = 0; i < ds.size(); i++) {
         System.out.println(ds.get(i));
         }
         **/

        List<String> ds = new ArrayList<>();
        ds.add("Quang");
        ds.add("Minh");
        ds.add("Hung");
        ds.add("Quang");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println(ds.get(i));
        }

        Set<String> set1 = new HashSet<>();
        set1.add("Bảo");
        set1.add("Sinh");

        ds.addAll(set1);


    }
}
