package com.soft1841.ss;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFrame extends JFrame implements ActionListener {
    private JPanel topPanel;
    private JButton sentBtn, linkBtn;
    private JTextArea jTextArea;
    private Socket client;
    private JTextField jTextField;

    private ClientFrame() {
        init();
        setTitle("客户端");
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        topPanel = new JPanel();
        linkBtn = new JButton("连接服务器");
        sentBtn = new JButton("发送");
        linkBtn.setPreferredSize(new Dimension(100, 30));
        sentBtn.setPreferredSize(new Dimension(100, 30));
        jTextArea = new JTextArea();
        jTextArea.setPreferredSize(new Dimension(150, 40));

        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(200, 60));
        jTextField.setEditable(false);
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        jTextField.setFont(font);

        topPanel.setBackground(new Color(126, 126, 126));
        topPanel.add(linkBtn);
        topPanel.add(sentBtn);
        jTextArea.setFont(font);
        add(topPanel, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);
        add(jTextField, BorderLayout.SOUTH);

        linkBtn.addActionListener(this);
        sentBtn.addActionListener(this);

    }

    public static void main(String[] args) {
        new ClientFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == linkBtn) {
            try {
                client = new Socket("localhost", 12450);
                jTextField.setText("成功连接上服务器！");
                jTextArea.append("\n" + " ");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == sentBtn) {
            try {
                String string = jTextArea.getText();
                BufferedWriter buf;
                buf = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                buf.write(string);
                buf.flush();
                buf.close();
                jTextField.setText("信息已发送！");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}