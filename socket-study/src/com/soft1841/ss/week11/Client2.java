package com.soft1841.ss.week11;

import java.io.*;
import java.net.Socket;

/**
 * 客户端向服务端发送非文本
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("172.20.10.5",12450);
        System.out.println("连上了");
        File file =new File("F:/1.jpg");
        byte[] b = new byte[(int) file.length()];
        InputStream in = new FileInputStream(file);
        in.read();
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        bos.write(b);
        in.close();
        bos.close();
    }
}
