package com.soft1841.ss.week11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server11 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("服务器启动");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread11 server = new ServerThread11(socket);
            new Thread(server).start();
        }
    }
}


class ServerThread11 implements  Runnable{
    private Socket socket;

    public  ServerThread11(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        System.out.println("客户端" +socket.getInetAddress() +"连接成功");
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(br.readLine());
            br.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}