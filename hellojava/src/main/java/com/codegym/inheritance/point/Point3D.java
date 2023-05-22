package com.codegym.inheritance.point;

// quan hệ kế thừa: is a
public class Point3D extends Point2D{
    private float z;

    public Point3D() {
    }
    public Point3D(float x, float y, float z){
        /**
        super(x, y);
        this.z = z;

         this.z  = z;
         this.setX(x);
         this.setY(y);
         **/

        this.z  = z;
        this.setX(x);
        this.setY(y);

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float [] getXYZ() {
        return new float[]{this.getX(), this.getY(), this.z};
    }

    public void setXYZ(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("Point 3D (%s,%s, %s)", this.getX(), this.getY(), this.getZ());
    }

    @Override
    public void moveOneUnit() {
        super.moveOneUnit();
        this.z = this.z + 1;
    }
}
