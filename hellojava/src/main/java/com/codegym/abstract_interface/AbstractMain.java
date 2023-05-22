package com.codegym.abstract_interface;

public class AbstractMain {
    public static void main(String[] args) {
        // khong the tao doi tuong tu lop abstract
//        Animal tiger = new Animal();

        // Đa hình: 1 bien thuoc kieu du lieu cua lop cha, tham chieu tôi 1 doi tuong cua lop con
        // Đa hình: 1 doi tuong co the co nhiều hình dạng khác nhau
        Animal a = new Tiger();
        a = new Chicken();

        // Đa hình: 1 phương thức có the thuc hien theo nhieu cach khac nhau
        a.makeSound();

//        Ediable b = new Ediable() ; // Khong the tao doi tượng của interface.






    }
}
