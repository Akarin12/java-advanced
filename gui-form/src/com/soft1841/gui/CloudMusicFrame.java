package com.soft1841.gui;

import javax.swing.*;
import java.awt.*;

public class CloudMusicFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton 搜索btn;
    private JButton 发现btn;
    private JButton MVbtn;
    private JButton 朋友btn;
    private JPanel centerPanel;
    private JLabel bottomLabel;
    private JLabel bannerLabel;

    public static void main(String[] args) throws Exception {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        JFrame frame = new JFrame("CloudMusicFrame");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setContentPane(new CloudMusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

