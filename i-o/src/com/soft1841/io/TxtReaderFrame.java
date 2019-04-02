package com.soft1841.io;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TxtReaderFrame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton confirmButton;
    private JPanel topPanel;
    private JTextArea contentArea;


    public TxtReaderFrame() {
        Init();
        setTitle("文本阅读窗体");
        setSize(new Dimension(640, 480));
        //居中对齐
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }

    public void Init() {
        //顶部面板
        inputField = new JTextField(25);
        inputField.setPreferredSize(new Dimension(150, 40));
        confirmButton = new JButton("确认");
        confirmButton.setPreferredSize(new Dimension(100, 40));
        topPanel = new JPanel();
        topPanel.add(inputField);
        topPanel.add(confirmButton);
        //给按钮注册监听
        confirmButton.addActionListener(this);
        add(topPanel, BorderLayout.NORTH);
        //中间多行文本域
        contentArea = new JTextArea();
        add(contentArea, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new TxtReaderFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = inputField.getText().trim();
        File file = new File(filePath);
        try {


            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            //使用byte构建新输出字符串
            String resultStr = new String(bytes);
            contentArea.append(resultStr);
            contentArea.append("\n\r");


        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IO操作异常");
        }
    }
}