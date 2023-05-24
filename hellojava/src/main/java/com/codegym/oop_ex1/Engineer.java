package com.codegym.oop_ex1;

public class Engineer extends Officer{
    private String branch;

    public Engineer(long id, String name, int age, String gender, String address, String branch) {
        super(id, name, age, gender, address);
        this.branch = branch;
    }

    public Engineer(String branch) {
        this.branch = branch;
    }
    public Engineer() {

    }

    @Override
    public String toString() {
        return "Engineer{" +
                "branch='" + branch + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
