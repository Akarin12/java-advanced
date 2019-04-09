package com.soft1841.ts;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test extends JFrame {
    private JLabel numLabel, timeLabel;
    private JPanel colorPane, colorPanel;


    public Test() {
        Init();
        setTitle("新建");
        setSize(new Dimension(1000, 700));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void Init() {
        Font font = new Font("Algerian", Font.BOLD, 60);
        //时间
        timeLabel = new JLabel();
//        setLayout(new FlowLayout(FlowLayout.LEFT, 200, 200));
        add(timeLabel, BorderLayout.SOUTH);
        timeLabel.setFont(font);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();

        //随机数
        numLabel = new JLabel();
        setLayout(new FlowLayout(FlowLayout.CENTER, 200, 200));
        add(numLabel, BorderLayout.NORTH);

        numLabel.setFont(font);
        RandomNum randomNum = new RandomNum();
        randomNum.setNumLabel(numLabel);
        randomNum.start();

        //跳跳乐
        colorPane = new JPanel();
        add(colorPane, BorderLayout.EAST);
        RgbThread rgbThread = new RgbThread();
        rgbThread.setMovePane(colorPane);
        rgbThread.start();

        colorPanel = new JPanel();
        colorPanel.add(numLabel);
        add(colorPanel);
        RandomColor randomColor = new RandomColor();
        randomColor.setColor(colorPanel);
        randomColor.start();
    }

    public static void main(String[] args) {
        new Test();
    }
}

/**
 * 随机数
 */
class RandomNum extends Thread {
    private JLabel numLabel;

    public void setNumLabel(JLabel numLabel) {
        this.numLabel = numLabel;
    }

    @Override
    public void run() {
        Random random = new Random();
        int num;
        while (true) {
            num = random.nextInt(100);
            String str = Integer.toString(num);
            numLabel.setText(str);
            int redRandom = random.nextInt(256);
            int greenRandom = random.nextInt(256);
            int blueRandom = random.nextInt(256);
            Color color = new Color(redRandom, greenRandom, blueRandom);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * 随机颜色
 */
class RandomColor extends Thread implements Runnable {
    JPanel jPanel;

    public void setColor(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            jPanel.setBackground(color);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 时间
 */
class TimeThread extends Thread {
    private JLabel timeLabel;

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
            timeLabel.setText(sf.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class RgbThread extends Thread {
    private JPanel movePane;

    public void setMovePane(JPanel movePane) {
        this.movePane = movePane;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            int x = random.nextInt(1000);
            int y = random.nextInt(700);
            movePane.setBackground(new Color(r, g, b));
            movePane.setBounds(x, y, 40, 40);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}