package com.codegym.oop;

public class Student {
    // thuộc tính
    public int id;      // biến instane/ biến của đối tượng
    public String name;     //null
    public int age;         //0
    public String phone;    // null


    // Hàm khởi tạo không có tham số
    public Student() {
        this.age = 18;

    }
    // hàm khởi tạo có tham số
    public Student(int id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone  = phone;

    }
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }else{
            throw new RuntimeException("Age khong duoc nho hon 0");
        }

    }

    public String getPhone() {
        return this.phone.substring(0, 7) + "xxx";
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.printf("ID: %s Name: %s AGE %s PHONE %s", s1.id, s1.name, s1.age, s1.phone);


        s1.setAge(10);      // kiểm soát việc cập nhật thuộc tính bất hợp lệ
        s1.age = -10;       // cập nhật thuộc tinh


        Student s2 = new Student(1, "Nhat Thu", 18, "0399578134");
        System.out.println(s2.phone);       // kiểm soát việc truy cập/truy xuất/lấy ra thuộc tính của đối tượng
        System.out.println(s2.getPhone());

//        Student s2 = null;
//        System.out.println(s2);
    }
    public String getName() {
        boolean sex;        // biến cục bộ
        String address;

        return this.name;
    }
}
