package com.codegym.inheritance.point;

public class PointMain {
    public static void main(String[] args) {

        Point2D[] points = createPoints(3);

        showPoints(points);
        movingPoints(points);
        showPoints(points);

    }

    public static Point2D [] createPoints(int size) {
        Point2D[] points = new Point2D[size];

        points[0] = new Point3D(5, 1, 5);
        points[1] = new Point2D(2, 7);
        points[2] = new Point2D(1, 1);
        return points;
    }
    public static void showPoints(Point2D[] points) {
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i]);
        }
    }

    public static void movingPoints(Point2D[] points) {
        System.out.println("Moving one unit");
        for (int i = 0; i < points.length; i++) {
            points[i].moveOneUnit();
        }
    }
}
