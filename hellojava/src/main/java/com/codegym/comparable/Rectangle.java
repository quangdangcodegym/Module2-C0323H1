package com.codegym.comparable;

import java.util.Arrays;
import java.util.Comparator;

public class Rectangle extends Shape implements Comparable<Rectangle>{

    private float height;
    private float width;

    public Rectangle(String color, boolean filled, float height, float width) {
        super(color, filled);
        this.height = height;
        this.width = width;
    }
    public Rectangle() {

    }

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public float getArea() {
        return this.height*this.width;
    }

    public float getPerimeter() {
        return (this.width + this.height)*2;
    }

    @Override
    public String toString() {
        return String.format("%s - %s area: %s , perimeter: %s", this.width, this.height, this.getArea(), this.getPerimeter());
    }

    public static void main(String[] args) {
        Rectangle r0 = new Rectangle(5, 1);
        Rectangle r1 = new Rectangle(15, 2);
        Rectangle r2 = new Rectangle(2, 2);
        Rectangle r3 = new Rectangle(8, 7);
        Rectangle r4 = new Rectangle(1, 10);

        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0]  = r0;
        rectangles[1]  = r1;
        rectangles[2]  = r2;
        rectangles[3]  = r3;
        rectangles[4]  = r4;

        /**
         Dùng comparable: thì chỉ sắp xếp được 1 tiêu chí
        System.out.println("Sắp xếp theo diện tích");
        Arrays.sort(rectangles);        // Objects[]
        printRectangles(rectangles);

        System.out.println("Sắp xếp theo chu vi");
        Arrays.sort(rectangles);
        printRectangles(rectangles);

         */

        System.out.println("Sắp xếp theo diện tích");
        Comparator comparatorByArea = new ComparatorByArea();
        Arrays.sort(rectangles, comparatorByArea);
        printRectangles(rectangles);


        System.out.println("Sắp xếp theo chu vi");

        Comparator comparatorByPerimeter = new ComparatorByPerimeter();
        Arrays.sort(rectangles, comparatorByPerimeter);
        printRectangles(rectangles);



    }

    public static void printRectangles(Rectangle[] rectangles) {
        for (Rectangle r : rectangles) {
            System.out.println(r);
        }
    }

    public static void sortRectanglesComparable(Rectangle[] rectangles) {
        for (int i = 0; i < rectangles.length-1; i++) {
            for (int j = i + 1; i < rectangles.length - 1; j++) {
//                if (rectangles[i].compareTo(rectangles[j])) {
//                    Rectangle temp = rectangles[i];
//                    rectangles[i] = rectangles[j];
//                    rectangles[j] = temp;
//                }
            }
        }
    }
    /**
    public static void sortRectanglesComparator(Rectangle[] rectangles, Comparator comparator) {
        for (int i = 0; i < rectangles.length-1; i++) {
            for (int j = i + 1; i < rectangles.length - 1; j++) {
//                if (comparator.compare(rectangle[i], rectangle[j]) {
//                    Rectangle temp = rectangles[i];
//                    rectangles[i] = rectangles[j];
//                    rectangles[j] = temp;
//                }
            }
        }
    }
     **/

    @Override
    public int compareTo(Rectangle o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() == o.getArea()) {
            return 0;
        }
        return -1;
    }
}
