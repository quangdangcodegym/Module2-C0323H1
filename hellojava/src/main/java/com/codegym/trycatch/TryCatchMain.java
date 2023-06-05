package com.codegym.trycatch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TryCatchMain {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Nhập b: ");
        int b = Integer.parseInt(scanner.nextLine());
        try {
            div2Number(5, b);
        } catch (LoiChia0 loiChia0) {
            System.out.println("Xu ly o lop tren");
        }



    }


    private static float div2Number(int a, int b) throws LoiChia0 {
        try {
            int c = a / b;
            return c;
        } catch (ArithmeticException arithmeticException) {
            System.out.println(arithmeticException.getMessage());
            throw new LoiChia0();
        }

    }
    private static float div2NumberType2(int a, int b) throws ArithmeticException  {
        int c = a / b;      // throw new ArithmeticException
        return c;

    }

    public void demoRuntimeException() {
        int []arr = {4, 12, 7};

        System.out.println("Nhập vào vị trí muốn xem: ");
        int index = Integer.parseInt(scanner.nextLine());

        System.out.println(arr[index]);

        System.out.println("Hello C0323H1");
    }

    public void solveExceptionWithTryCatch() {
        try {
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println("OK");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi rồi");
        }
        System.out.println("123");
    }

    public void solveExceptionWithMultiCatch() {
        Queue<String> queue = new PriorityQueue<>();


        try {
            System.out.println("Nhập vào số a: ");
            int a = Integer.parseInt(scanner.nextLine());
            queue.remove();


        } catch (NoSuchElementException e) {
            System.out.println("Ngoai le NoSuchElementException");
            System.out.println(e.getMessage());
            e.printStackTrace();
            ;
        } catch (NumberFormatException e) {
            System.out.println("Ngoai le NumberFormatException");
        } catch (Exception e) {
            System.out.println("Ngoai le Exception");
        }


//        System.out.println("End program");
    }

    public void trycathCheckedException() {
        try {
            FileReader fileWriter = new FileReader("D:\\TEST");

            System.out.println("aaaaa");
        } catch (IOException e) {
            System.out.println("File khong ton tai");
        }
    }
    public void useFinally() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("D:\\THUY.txt");


        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException ioException) {

            }
        }
    }
}
