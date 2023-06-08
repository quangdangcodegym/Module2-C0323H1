package com.codegym.lamda.c10;

import com.codegym.lamda.AddFunc;
import com.codegym.lamda.MyFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class App {
    public int action(int a, int b, MyFunction func) {
        return func.accept(a, b);
    }

    public static void main(String[] args) {
        App app = new App();
        // Co dien
        MyFunction addFunc = new AddFunc();
        app.action(3, 5, addFunc  );

        // Lớp nặc danh
        int kq2 = app.action(5, 5, new MyFunction() {
            @Override
            public int accept(int a, int b) {
                return a * b;
            }

        });
        System.out.println(kq2);

        // thay bang lamda =
        int kq3 = app.action(5, 5, (a, b) -> a * b);
        System.out.println(kq3);






    }
}
