package com.soft1841.io;

import java.io.File;
import java.io.IOException;

/**
 * File基础操作1
 */
public class FeilDemo1 {
    public static void main(String[] args) throws IOException {
        File file =new File("D:/README.me");
        //如果file不存在，创建新文件
        if (!file.exists()){
        file.createNewFile();
        }

    }
}
