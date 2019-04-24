package com.soft1841.ts.join;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ClockFrame extends JFrame {
    private JPanel jPanel;
    private JLabel timeLabel;
    private TimerTask clockTask;
    private Timer timer;

    public ClockFrame() {
        Init();
        setTitle("Clock");
        setSize(new Dimension(500, 400));
        setLocation(1425, 640);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Init() {
        jPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                try {
                    Image bg = ImageIO.read(new File("F:/000.jpg"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 150));
        add(jPanel);

        timeLabel = new JLabel();
        jPanel.add(timeLabel);
        timeLabel.setFont(new Font("04b_21", 1, 21));
        timeLabel.setForeground(Color.CYAN);
        clockTask = new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(new Date());
                timeLabel.setText(timeString);
                if (timeString.equals("2019-04-16 09:16:50") || timeString.equals("2019-04-16 09:20:20")) {
                    JOptionPane.showMessageDialog(timeLabel, "时间到~~");
                }
            }
        };
        timer = new Timer();
        timer.schedule(clockTask, 10, 10);
    }

    public static void main(String[] args) {
        new ClockFrame();
    }
}