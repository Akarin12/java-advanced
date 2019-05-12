package com.soft1841.ss.week11;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 客户端从服务端接收文本数据
 */
public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.40.173.120",11451);
        System.out.println("ll");
        InputStream in  =socket.getInputStream();
        byte[] b = new byte[1024];
        in.read();
        System.out.println(new String(b));
        in.close();
        socket.close();
    }
}