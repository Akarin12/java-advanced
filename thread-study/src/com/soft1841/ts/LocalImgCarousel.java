package com.soft1841.ts;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalImgCarousel extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JPanel imgPanel;

    public LocalImgCarousel() {
        init();
        setTitle("轮播");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        chooseBtn = new JButton("选择图片");
        add(chooseBtn, BorderLayout.NORTH);
        chooseBtn.addActionListener(this);

        imgPanel = new JPanel();
        add(imgPanel);

        PlayMusic playMusic = new PlayMusic();
        Thread thread = new Thread(playMusic);
        thread.start();

    }

    public static void main(String[] args) {
        new LocalImgCarousel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            JLabel imgLabel = new JLabel();

            imgPanel.add(imgLabel);

            ChooseImg chooseImg = new ChooseImg();
            chooseImg.setBgLabel(imgLabel);
            new Thread(chooseImg).start();
        }
    }
}

class ChooseImg implements Runnable {
    private JLabel bgLabel;
    private JFileChooser fileChooser;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("F:/22"));
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //获取选中的所有文件
            File[] files = fileChooser.getSelectedFiles();
            int i = 0;
            int len = files.length - 1;
            while (true) {
                try {
                    File file = new File(String.valueOf(files[i]));
                    InputStream inputStream = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    inputStream.read(bytes);
                    Icon icon = new ImageIcon(bytes);
                    bgLabel.setIcon(icon);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    if (i == len) {
                        i = 0;
                    }
                } catch (IOException e) {
                    System.err.println("IO异常");
                }
            }
        }
    }

}



class PlayMusic implements Runnable {//背景音乐播放

    @Override
    public void run() {
        try {
            URL cb;
            File f = new File("F:/01_stellarissuite_creationandbeyond.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
            aau.loop();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}