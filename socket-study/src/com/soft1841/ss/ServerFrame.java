package com.soft1841.ss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFrame extends JFrame implements ActionListener {
    private JTextArea contentTextArea;
    private JButton runButton;
    private JPanel topPanel;

    private ServerFrame() {
        init();
        setTitle("服务器端");
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        topPanel = new JPanel();
        runButton = new JButton("启动");
        runButton.setPreferredSize(new Dimension(70, 40));
        topPanel.add(runButton);
        topPanel.setBackground(new Color(126, 126, 126));
        contentTextArea = new JTextArea();
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        contentTextArea.setFont(font);
        contentTextArea.setEditable(false);
        add(topPanel, BorderLayout.NORTH);
        add(contentTextArea, BorderLayout.CENTER);

        runButton.addActionListener(this);

    }

    public static void main(String[] args) {
        new ServerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        linkThread linkThread = new linkThread();
        linkThread.setContentTextArea(contentTextArea);
        new Thread(linkThread).start();

    }
}




class linkThread implements Runnable {
    private JTextArea contentTextArea;

    public void setContentTextArea(JTextArea contentTextArea) {
        this.contentTextArea = contentTextArea;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12450);
            contentTextArea.append("服务器启动！");
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread4 server = new ServerThread4();
                server.setContentTextArea(contentTextArea);
                server.setSocket(socket);
                new Thread(server).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}



class ServerThread4 implements Runnable {
    private Socket socket;
    private JTextArea contentTextArea;

    public void setContentTextArea(JTextArea contentTextArea) {
        this.contentTextArea = contentTextArea;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端" + socket.getInetAddress() + "连接成功！");
        contentTextArea.append("\n\n" + "客户端" + socket.getInetAddress() + "连接成功！");
        InputStream inputStream = null;
        String str = null;
        try {
            inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while (br.read() != -1) {
                str = br.readLine();
            }
            contentTextArea.append("\n\n" + socket.getInetAddress() + "说:\n" + str);
            br.close();
            socket.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IO操作异常！");
        }
    }
}