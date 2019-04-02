package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageReaderFrame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton confirmButton;
    private JPanel topPanel;
    private JLabel contentArea;

    public ImageReaderFrame() {
        init();
        setTitle("图片阅读窗体");
        setSize(new Dimension(640, 480));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void init() {
        inputField = new JTextField(25);
        inputField.setPreferredSize(new Dimension(150, 40));
        confirmButton = new JButton("确认");
        confirmButton.setPreferredSize(new Dimension(100, 40));
        topPanel = new JPanel();
        topPanel.add(inputField);
        topPanel.add(confirmButton);
        confirmButton.addActionListener(this);
        add(topPanel, BorderLayout.NORTH);
        contentArea = new JLabel();
        add(contentArea, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new ImageReaderFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = inputField.getText().trim();
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            contentArea.setIcon(new ImageIcon(bytes));
            inputStream.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IO操作异常");
        }
    }
}
