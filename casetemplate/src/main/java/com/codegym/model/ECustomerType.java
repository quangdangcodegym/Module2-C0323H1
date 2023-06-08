package com.codegym.model;

public enum ECustomerType {
    NORMAL(1 , "Normal"), VIP(2, "Vip"), SUPERVIP (3, "Super Vip");
    private long id;
    private String name;

    ECustomerType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ECustomerType findById(long id) {
        for (ECustomerType e : ECustomerType.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    public static ECustomerType find(String type) {
        for (ECustomerType e : ECustomerType.values()) {
            if (e.toString().equals(type)) {
                return e;
            }
        }
        return null;
    }
    //    public static void main(String[] args) {
//        for (ECustomerType e : ECustomerType.values()) {
//            System.out.println(e);
//            System.out.println(e.name + " " + e.id);
//        }
//    }
}
