package com.codegym.inheritance.basic;

public class Shape {
    private String color;
    protected boolean filled;


    public Shape() {
        super();
        color = "White";
        System.out.println("Shape contructor no parameter");
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
//        return "Color: " + this.color + " -- filled: " + this.filled;
        return String.format("Color: %s --- filed: %s", this.color, this.filled);
    }

}
