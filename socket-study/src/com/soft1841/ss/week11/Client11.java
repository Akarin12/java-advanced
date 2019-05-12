package com.soft1841.ss.week11;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端向服务器发
 */
public class Client11 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8081);
        System.out.println("成功连上服务器");
        Scanner scanner = new Scanner(System.in);
        BufferedWriter buf;
        System.out.println("请输入一行信息：");
        String str = scanner.nextLine();
        buf = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        buf.write(str);
        buf.flush();
        buf.close();
    }
}
