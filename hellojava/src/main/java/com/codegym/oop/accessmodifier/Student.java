package com.codegym.oop.accessmodifier;

public class Student {
    public int id;
    public String name;
    public int age;            // mức do truy cập private: thì chỉ chỉ truy cập trong cùng 1 lớp
    String phone;               // mức do truy cập default:thì chỉ chỉ truy cập trong cùng 1 package

    public Student() {

    }
    public Student(int id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone  = phone;


    }

    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.name);
    }
}
