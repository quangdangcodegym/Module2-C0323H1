package com.codegym.abstract_interface;

public abstract class Animal implements Ediable{
    public abstract void makeSound();

    public void sleep() {
        System.out.println("zzzzzz");
    }
    float height;


    abstract void makeSound1();

    //public abstract void howToEat();
}
