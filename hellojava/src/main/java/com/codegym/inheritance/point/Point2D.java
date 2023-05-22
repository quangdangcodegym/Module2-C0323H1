package com.codegym.inheritance.point;

public class Point2D {
    private float x;        // biến đôi tương/instance
    private float y;

    public Point2D(float x, float y) {      // tham số
        this.x = x;
        this.y = y;
    }
    public Point2D() {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
//        float[] arr = new float[2];
//        arr[0] = x;
//        arr[1] = y;

//        float[] results = {x, y};
//        return  results;

        return new float[]{x, y};
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Point 2D (%s,%s)", this.x, this.y);
    }

    public void moveOneUnit() {
        this.x = this.x + 1;
        this.y = this.y + 1;
    }
}
