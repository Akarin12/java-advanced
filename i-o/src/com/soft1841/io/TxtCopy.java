package com.soft1841.io;

import java.io.*;

/**
 * 文本复制
 */
public class TxtCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("E:/Hello.txt");
        if (srcFile.exists()) {
            File desFile = new File("E:/Hello副本.txt");
            Reader in = new FileReader(srcFile);
            char[] chars = new char[(int) srcFile.length()];
            in.read(chars);
            Writer out = new FileWriter(desFile);
            out.write(chars);
            in.close();
            out.close();
        }else {
            System.out.println("不存在");
        }
    }
}