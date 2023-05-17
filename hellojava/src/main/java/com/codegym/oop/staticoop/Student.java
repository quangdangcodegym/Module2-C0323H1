package com.codegym.oop.staticoop;

public class Student {
    public int id;
    public String name;
    public static String college;

    public Student() {

    }
    public Student(int id, String name, int age, String college) {
        this.id = id;
        this.name = name;
        this.college  = college;


    }
    static {
        System.out.println("Chạy vào khối khởi tạo static");
        college = "Hai Bà Trưng";
//        System.exit(0);

    }

    public static void main(String[] args) {

        System.out.println("Chay vào hàm mai");
    }

}
