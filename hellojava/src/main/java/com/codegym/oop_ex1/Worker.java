package com.codegym.oop_ex1;

public class Worker extends Officer{
    private int level;


    public Worker() {

    }
    public Worker(long id, String name, int age, String gender, String address, int level) {
        super(id, name, age, gender, address);
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "level=" + level +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
