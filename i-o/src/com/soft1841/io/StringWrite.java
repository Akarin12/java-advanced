package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

public class StringWrite {
    public static void main(String[] args) throws IOException {
        File desFile = new File("F:/ko↑ko↓.txt");
        System.out.println("随便输个啥:");
        Scanner scanner = new Scanner(System.in);
        String str =scanner.nextLine();
        char[] chars = str.toCharArray();
        Writer out = new FileWriter(desFile);
        out.write(chars);
        out.close();
    }
}