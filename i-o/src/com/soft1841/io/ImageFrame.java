package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Calendar;

public class ImageFrame extends JFrame {
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imgLabel;
    private JLabel txtLabel;
    private JLabel timeLabel;
    private Icon icon;

    public ImageFrame() throws IOException {
        init();
        setTitle("图片窗体");
        setSize(1000, 600);
        //窗体自动居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() throws IOException {
        topPanel = new JPanel();
        buttons = new JButton[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton("按钮" + i);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imgLabel = new JLabel();
        File srcfile = new File("E:/zaima.jpg");
        InputStream in = new FileInputStream(srcfile);
        byte[] bytes = new byte[(int) srcfile.length()];
        in.read(bytes);
        icon = new ImageIcon(bytes);
        imgLabel.setIcon(icon);
        add(imgLabel, BorderLayout.CENTER);

        //时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int mouth = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        int minute = calendar.get(calendar.MINUTE);
        int second = calendar.get(calendar.SECOND);
        String time = year + "-" + mouth + "-" + day + "  " + hour + ":" + minute + ":" + second;
        timeLabel = new JLabel(time);
        add(timeLabel,BorderLayout.WEST);
        //路径大小
        txtLabel = new JLabel(srcfile.getAbsolutePath()+"       大小:"+srcfile.length()/1024+"KB", JLabel.CENTER);
        txtLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        add(txtLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) throws IOException {
        new ImageFrame();

    }
}
