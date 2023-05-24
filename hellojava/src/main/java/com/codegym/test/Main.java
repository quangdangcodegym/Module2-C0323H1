package com.codegym.test;

public class Main {
    public static void main(String[] args) {
        Hinh h1 = new Tron();
        Hinh h2 = new TamGiac();
        Hinh h3 = new ChuNhat();

        DaGiac h4 = (DaGiac) h2;        // ep từ kiểu còn mơ hồ về cụ thể
        Hinh h5 = h1;                   // =>
        Tron h6 = (Tron)h1;
        h2 = h3;

        DaGiac[] daGiacs = new DaGiac[100000000];
    }
}
