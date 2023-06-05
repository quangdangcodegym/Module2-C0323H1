package com.codegym.file_io;

import java.io.*;
import java.util.Arrays;

public class FileMain {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("D:\\codegym.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("hello codeym");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String toString(char [] cbuf, int num) {
        String str = "";
        for (int i = 0; i < num; i++) {
            str += cbuf[i];
        }
        return str;
    }
    public void basicReadFile() {
        try {
            File file = new File("D:\\hello.txt");
            FileReader fileReader = new FileReader(file);
//            FileReader fileReader = new FileReader("D:\\hello.txt");

            int a1 = fileReader.read();
            System.out.println((char) a1 );

            int a2 = fileReader.read();
            System.out.println((char) a2 );

            int a3 = fileReader.read();
            System.out.println((char) a3 );

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void basicReadFileUseWhile() {
        try {
            File file = new File("D:\\hello.txt");
            FileReader fileReader = new FileReader(file);
//            FileReader fileReader = new FileReader("D:\\hello.txt");

            String str = "";
            int temp;
            while ((temp = fileReader.read()) != -1){
                str += (char) temp;
            }
            System.out.println(str);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void basicReadFileCBuf() {
        try {
            File file = new File("D:\\hello.txt");
            FileReader fileReader = new FileReader(file);
//            FileReader fileReader = new FileReader("D:\\hello.txt");

            char[] cbuf = new char[3];
            int num1 = fileReader.read(cbuf);
            System.out.println(Arrays.toString(cbuf));
            System.out.println(num1);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void basicReadFileCBuf1() {
        try {
            File file = new File("D:\\hello.txt");
            FileReader fileReader = new FileReader(file);
//            FileReader fileReader = new FileReader("D:\\hello.txt");

            String str = "";
            char[] cbuf = new char[3];
            int num = -1;
            while ((num = fileReader.read(cbuf)) != -1) {
                str += toString(cbuf, num);
            }
            System.out.println(str);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void bufferReader() {
        try {
            File file = new File("D:\\hello.txt");
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            String str = "";
            while ((line = bufferedReader.readLine()) != null) {
                str += line + "\n";
            }

            System.out.println(str);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    public void writeFileBasic() {
        try {
            FileWriter fileWriter = new FileWriter("D:\\xinchao.txt");
//            fileWriter.write(67);
//            fileWriter.write(48);

            fileWriter.write("Hello C02");


            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
