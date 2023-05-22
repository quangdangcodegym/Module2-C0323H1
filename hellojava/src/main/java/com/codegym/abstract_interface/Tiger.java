package com.codegym.abstract_interface;

public class Tiger extends Animal{
    @Override
    public void makeSound() {
        System.out.println("gu gu");
    }

    @Override
    protected void makeSound1() {
        
    }

    @Override
    public void howToEat() {
        System.out.println("Nau cao");
    }
}
