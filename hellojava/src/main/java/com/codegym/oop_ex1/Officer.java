package com.codegym.oop_ex1;

public class Officer {
    protected long id;
    protected String name;
    protected int age;
    protected String gender;
    protected String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Officer(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    public Officer(long id, String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.id = id;
    }

    public Officer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
