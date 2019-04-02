package com.soft1841.io;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        String str = "I love yyut";
        File file1 = new File("F:/out1.txt");
        if (!file1.exists()){
            file1.createNewFile();
        }

//        Writer writer = new FileWriter(file1,true);
//        writer.write(str.toCharArray());
//        writer.close();

        OutputStream out = new FileOutputStream(file1);
        PrintStream printStream = new PrintStream(out);
        printStream.print(str);
        System.out.println(str);

    }
}
