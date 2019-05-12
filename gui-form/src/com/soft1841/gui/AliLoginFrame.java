package com.soft1841.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AliLoginFrame {
    private JPanel mainPanel;
    private JLabel bannerLabel;
    private JLabel avatarLabel;
    private JTextField accountField;
    private JTextField passwordField;
    private JCheckBox 记住密码CheckBox;
    private JCheckBox 自动登录CheckBox;
    private JButton loginBtn;

    public AliLoginFrame() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "登陆成功！");
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        JFrame frame = new JFrame("TimLoginFrame");
        frame.setContentPane(new AliLoginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();//窗体自适应容器大小
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}