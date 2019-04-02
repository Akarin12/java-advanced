package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class JfileChooserTest extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JLabel pathLabel;
    private JFileChooser fileChooser;

    public JfileChooserTest() {
        Init();
        setTitle("JfileChooserTest");
        setSize(new Dimension(640, 480));
        //居中对齐
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void Init() {
        chooseBtn = new JButton("选择文件");
        chooseBtn.addActionListener(this);
        pathLabel = new JLabel("暂无选择");
        add(chooseBtn, BorderLayout.NORTH);
        Font font = new Font("微软雅黑", Font.BOLD, 26);
        pathLabel.setFont(font);
        add(pathLabel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new JfileChooserTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //创建JF对象
        fileChooser = new JFileChooser();
        //设置文件选择器默认路径
        fileChooser.setCurrentDirectory(new File("D:/"));
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
        //点击确认
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                InputStream inputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                pathLabel.setText(scanner.nextLine());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }


    }
}