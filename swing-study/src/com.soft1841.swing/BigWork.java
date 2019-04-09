package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BigWork extends JFrame implements ActionListener {
    private JButton chooseBtn, saveBtn, osBtn, newBtn;
    private JFileChooser fileChooser;
    private JPanel bottomPanel;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public BigWork() {
        Init();
        setTitle("新建");
        setSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void Init() {
        chooseBtn = new JButton("选择文件");
        saveBtn = new JButton("保存");
        osBtn = new JButton("另存为");
        newBtn = new JButton("新建");
        bottomPanel = new JPanel();
        bottomPanel.add(chooseBtn);
        bottomPanel.add(saveBtn);
        bottomPanel.add(osBtn);
        bottomPanel.add(newBtn);
        chooseBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        osBtn.addActionListener(this);
        newBtn.addActionListener(this);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(bottomPanel, BorderLayout.NORTH);
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new BigWork();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("F:/test"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                byte[] bytes = null;
                try {
                    InputStream inputStream = new FileInputStream(file);
                    bytes = new byte[(int) file.length()];
                    inputStream.read(bytes);
                    inputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String resultStr = new String(bytes);
                textArea.setText("");
                textArea.append(resultStr);
                setTitle(file.getAbsolutePath());

            }

        }

        if (e.getSource() == saveBtn) {
            String str = textArea.getText();
            File file = new File(getTitle());
            String name = getTitle();
            if (name.equals("新建")) {
                fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("F:/test"));
                fileChooser.setFileFilter(new FileNameExtensionFilter("txt(*.txt)", "txt"));
                fileChooser.setSelectedFile(new File("新建文本文档.txt"));
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file1 = fileChooser.getSelectedFile();
                    try {
                        file1.createNewFile();
                        OutputStream out = new FileOutputStream(file1);
                        PrintStream printStream = new PrintStream(out);
                        printStream.print(str);
                        out.close();
                        printStream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    setTitle(file1.getAbsolutePath());
                }
            } else {
                try {
                    OutputStream out = new FileOutputStream(file);
                    PrintStream printStream = new PrintStream(out);
                    printStream.print(str);
                    out.close();
                    printStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //另存为
        if (e.getSource() == osBtn) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("F:/test"));
            fileChooser.setFileFilter(new FileNameExtensionFilter("txt(*.txt)", "txt"));
            fileChooser.setSelectedFile(new File("新建文本文档.txt"));
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String str = textArea.getText();
                File file = fileChooser.getSelectedFile();
                try {
                    file.createNewFile();
                    OutputStream out = new FileOutputStream(file);
                    PrintStream printStream = new PrintStream(out);
                    printStream.print(str);
                    out.close();
                    printStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                setTitle(file.getAbsolutePath());
            }

        }

        if (e.getSource() == newBtn) {
            textArea.setText("");
            setTitle("新建");
        }


    }
}