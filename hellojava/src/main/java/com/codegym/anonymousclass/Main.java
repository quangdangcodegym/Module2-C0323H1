package com.codegym.anonymousclass;

public class Main {
    public static void main(String[] args) {
        Flyable a = new ChimChaoMao();

        Flyable b = new Flyable() {
            @Override
            public String fly() {
                return null;
            }
        };

    }
}
