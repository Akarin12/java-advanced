package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;

public class JfileChooserTest extends JFrame {


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

    }

    public static void main(String[] args) {
        new JfileChooserTest();
    }
}
