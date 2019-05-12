package com.soft1841.ss.week11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器向客户端发送文本数据(多线程)
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(11451);
        System.out.println("服务器启动,端口号:" + ss.getLocalPort());
        OutputStream out;
        System.out.println("请输入要广播的内容");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        scanner.close();
        int count = 0;
        while (true) {
            Socket socket = ss.accept();
            ServerThread1 serverThread1 = new ServerThread1(socket);
            new Thread(serverThread1).start();
            count++;
            System.out.println(count);
        }
    }
}


class ServerThread1 implements  Runnable{
    private Socket socket;

    public  ServerThread1(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        System.out.println("客户端" +socket.getInetAddress() +"连接成功");
        OutputStream out = null;
        try {
            out = socket.getOutputStream();
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(out));
            System.out.println(br);
            br.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}