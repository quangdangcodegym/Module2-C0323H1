package com.codegym.model;

public enum ECategory {
    PHONE(1 , "Phone"), TABLET(2, "Tablet");
    private long id;
    private String name;

    ECategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ECategory findECategory(String name) {
        for (ECategory e : ECategory.values()) {
            if (e.toString().equals(name)) {
                return e;
            }
        }
        return null;
    }
    public static ECategory findECategory(int id) {
        for (ECategory e : ECategory.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
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
}
