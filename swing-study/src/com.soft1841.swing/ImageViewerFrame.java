package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

/**
 * 使用卡片布局实现多图浏览
 */
public class ImageViewerFrame extends JFrame implements ActionListener {
    private JButton chooseBtn, preBtn, nextBtn, fisBtn, finBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel, bottomPanel;
    private CardLayout cardLayout;

    public ImageViewerFrame() {
        Init();
        setTitle("ImageViewerFrame");
        setSize(new Dimension(640, 480));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void Init() {
        //底部面板加三按钮,设监听
        chooseBtn = new JButton("选择图片");
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        fisBtn = new JButton("第一张");
        finBtn = new JButton("最后一张");
        bottomPanel = new JPanel();
        bottomPanel.add(fisBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(chooseBtn);
        bottomPanel.add(nextBtn);
        bottomPanel.add(finBtn);
        preBtn.addActionListener(this);
        chooseBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        fisBtn.addActionListener(this);
        finBtn.addActionListener(this);
        add(bottomPanel, BorderLayout.SOUTH);
        //创建中间面板,加入卡片布局
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(225, 229, 198));
        add(centerPanel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ImageViewerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\Yue Tang\\Pictures"));
            fileChooser.setMultiSelectionEnabled(true);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                //获取选中的所有文件
                File[] files = fileChooser.getSelectedFiles();
                for (File f : files) {
                    //对每个f,创建字节输入流读入字节数组,构建icon,设置给jlabel
                    byte[] bytes = null;
                    try {
                        InputStream in = new FileInputStream(f);
                        bytes = new byte[(int) f.length()];
                        in.read(bytes);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Icon icon = new ImageIcon(bytes);
                    JLabel imgLabel = new JLabel();
                    imgLabel.setIcon(icon);
                    centerPanel.add(imgLabel);
                }
            }
        }

        if (e.getSource() == preBtn) {
            cardLayout.previous(centerPanel);
        }
        if (e.getSource() == nextBtn) {
            cardLayout.next(centerPanel);
        }
        if (e.getSource() == fisBtn) {
            cardLayout.first(centerPanel);
        }
        if (e.getSource() == finBtn) {
            cardLayout.last(centerPanel);
        }

    }
}