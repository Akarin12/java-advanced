package com.soft1841.io;

import java.io.*;
import java.util.UUID;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //指定源文件
        File srcFile = new File("E:/zaima.jpg");
        //改名
        String srcFileName = srcFile.getName();
        int position = srcFileName.indexOf(".");
        String sufficName = srcFileName.substring(position + 1);
        String newName = UUID.randomUUID().toString();
        //指定目标文件
        File desFile = new File("E:/" + newName + "." + sufficName);
        //创建字节数组为源文件大小，转换为int
        byte[] bytes = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream in = new FileInputStream(srcFile);
        in.read(bytes);
        OutputStream out = new FileOutputStream(desFile);
        out.write(bytes);
        in.close();
        out.close();
    }
}
