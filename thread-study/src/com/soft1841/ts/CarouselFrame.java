package com.soft1841.ts;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CarouselFrame extends JFrame {
    private JLabel bgLabel, imgLabel, imgI, imgII;

    public CarouselFrame() {
        init();
        setTitle("轮播");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        bgLabel = new JLabel();
        add(bgLabel);
        CarouselThread ct = new CarouselThread();
        ct.setBgLabel(bgLabel);
        new Thread(ct).start();

        imgLabel = new JLabel();
        add(imgLabel, BorderLayout.NORTH);
        CarouselIIThread carouselIIThread = new CarouselIIThread();
        carouselIIThread.setBgLabel(imgLabel);
        new Thread(carouselIIThread).start();

        imgI = new JLabel();
        add(imgI, BorderLayout.EAST);
        CarouselIIThreadI carouselIIThread2 = new CarouselIIThreadI();
        carouselIIThread2.setBgLabel(imgI);
        new Thread(carouselIIThread2).start();

        imgII = new JLabel();
        add(imgII, BorderLayout.WEST);
        CarouselIIThreadII carouselIIThread3 = new CarouselIIThreadII();
        carouselIIThread3.setBgLabel(imgII);
        new Thread(carouselIIThread3).start();
    }

    public static void main(String[] args) {
        new CarouselFrame();
    }
}


class CarouselThread implements Runnable {
    private String[] imgs = {"F:/22/1.jpg", "F:/22/2.jpg", "F:/22/3.jpg", "F:/22/4.jpg", "F:/22/5.jpg", "F:/22/6.jpg"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        int i = 0;
        int len = imgs.length - 1;
        while (true) {
            try {
                File file = new File(imgs[i]);
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

class CarouselIIThread implements Runnable {
    private String[] imgs = {"F:/33/1.gif", "F:/33/2.gif", "F:/33/3.gif", "F:/33/4.gif", "F:/33/5.gif", "F:/3/6.gif"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        int i = 0;
        int len = imgs.length - 1;
        while (true) {
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                bgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                try {
                    Thread.sleep(900);
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

class CarouselIIThreadII implements Runnable {
    private String[] imgs = {"F:/33/1.gif", "F:/33/2.gif", "F:/33/3.gif", "F:/33/4.gif", "F:/33/5.gif", "F:/3/6.gif"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        int i = 0;
        int len = imgs.length - 1;
        while (true) {
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                bgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                try {
                    Thread.sleep(500);
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

class CarouselIIThreadI implements Runnable {
    private String[] imgs = {"F:/33/1.gif", "F:/33/2.gif", "F:/33/3.gif", "F:/33/4.gif", "F:/33/5.gif", "F:/3/6.gif"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        int i = 0;
        int len = imgs.length - 1;
        while (true) {
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                bgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                try {
                    Thread.sleep(1200);
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