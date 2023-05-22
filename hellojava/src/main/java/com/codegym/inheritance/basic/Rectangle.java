package com.codegym.inheritance.basic;

public class Rectangle extends Shape{
    private float width;
    private float height;

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }


    public Rectangle(float w, float h) {
        super();
        this.width = w;
        this.height = h;
    }

    public Rectangle(float w, float h, String color, boolean filled) {
        /**
//        super();
        super(color, filled);
        this.width = w;
        this.height = h;


         //        super();
         super.setColor(color);
         super.filled = filled;
         this.width = w;
         this.height = h;
         **/
        this.width  = w;
        this.height = h;
        this.setColor(color);
    }
    public Rectangle() {
//        super();
    }
    @Override
    public String toString(){
        return String.format("Color: %s --- filed: %s width: %s height: %s", this.getColor(), this.filled, this.width, this.height);
    }
}
