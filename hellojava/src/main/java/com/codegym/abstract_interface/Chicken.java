package com.codegym.abstract_interface;

public class Chicken extends Animal{
    @Override
    public void makeSound() {

        System.out.println(height);
        System.out.println("Quac Quac");
    }

    @Override
    protected void makeSound1() {

    }

    @Override
    public void howToEat() {
        System.out.println("Luoc cham nuoc man");
    }


}
