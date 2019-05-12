package com.soft1841.ss.week11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * 客户端向服务端发送非文本
 */
public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12450);
        System.out.println("服务器启动,端口号:" + ss.getLocalPort());
        Socket socket;
        while (true) {
            socket = ss.accept();
            ServerThread2 serverThread2= new ServerThread2(socket);
            new Thread(serverThread2).start();
        }
    }
}

class ServerThread2 implements Runnable{
private Socket socket;
    public  ServerThread2(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println(socket.getInetAddress()+"入了");

        try {
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            File file = new File("F:/" + UUID.randomUUID().toString() + ".jpg");
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] data = new byte[1024];
            int tmp;
            while ((tmp = bis.read(data)) != -1){
                bos.write(data,0,tmp);
            }
            bos.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
