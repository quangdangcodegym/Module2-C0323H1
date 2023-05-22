package com.codegym.inheritance.basic;

public class ShapeMain {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        Rectangle rectangle1 = new Rectangle(5f, 10f);

        System.out.println(rectangle1.toString());


        Shape s1 = new Rectangle(5f, 10f);

        // Tai thoi diem bien dich: goi phuong thuc toString() cua kieu khai bao
        // Tai thoi diem runtime: goi phuong thuc toString() cua kieu thuc te
//        System.out.println(s1.toString());
//
//        if (rectangle instanceof Rectangle) {
//            System.out.println("La kieu Rectangle");
//        }
//        if (rectangle instanceof Shape) {
//            System.out.println("La kieu Shape");
//        }

        Shape s5 = new Rectangle();
        if (s5 instanceof Rectangle) {
            System.out.println("La kieu Rectangle");
        }
        if (s5 instanceof Shape) {
            System.out.println("La kieu Shape");
        }






    }
}
