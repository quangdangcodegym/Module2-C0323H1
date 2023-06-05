package com.codegym.file_io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExIO {
    public static Scanner scanner = new Scanner(System.in);

    public static final String fileName ="./numbers.txt";


    public static void main(String[] args) {
        System.out.println("Menu chọn");
        System.out.println("Nhập 1. Tính tổng rồi chèn vào cuối file");
        System.out.println("Nhập 2. Tìm lớn nhất rồi chèn vào cuối file");

        int actionMenu = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = readNumbersFromFile(fileName); // numbers: [5,3,1]

        switch (actionMenu) {
            case 1:
                try {
                    int sum = getTotalNumbers(numbers); //
                    numbers.add(sum);       // [5,3,1,9]
                    insertNumbersToFile(fileName, numbers);
                }catch (RuntimeException runtimeException) {
                    System.out.println("Mảng rỗng không thể thực hiện được");
                }
                break;
            case 2:
                try {
                    int max = getMaxNumbers(numbers);
                    numbers.add(max);
                    insertNumbersToFile(fileName, numbers);
                } catch (RuntimeException runtimeException) {
                    System.out.println("Mảng rỗng không thể thực hiện được");
                }
                break;
        }


    }

    private static void insertNumbersToFile(String fileName, List<Integer> numbers) { // [5,3,1,9]
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Integer item : numbers) {
                bufferedWriter.write(item + "\n");
            }

            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getMaxNumbers(List<Integer> numbers) throws RuntimeException { // []
        if (numbers.size() == 0) {
           throw new RuntimeException("Không thể tìm max khi mảng rỗng");
        }
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    private static int getTotalNumbers(List<Integer> numbers) throws RuntimeException{
        if (numbers.size() == 0){
           throw new RuntimeException("Không thể tìm tong mảng rỗng");
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    public static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try {
//            FileReader fileReader = new FileReader("D:\\CODEGYM\\CODEGYM\\Module2\\C0323H1\\hellojava\\numbers.txt");
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                int num = Integer.parseInt(line);
                numbers.add(num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numbers;
    }
}
