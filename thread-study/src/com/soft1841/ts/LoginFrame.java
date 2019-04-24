package com.soft1841.ts;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoginFrame extends JFrame implements ActionListener {
    private int width;
    private int height;
    private NewButton loginBtn, logoutBtn;
    private ShadePan shadePanel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel text,pass;

    public LoginFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init() {
        setLayout(null);
        shadePanel = new ShadePan();
        shadePanel.setColor1(new Color(222, 146, 155));
        shadePanel.setColor2(new Color(222, 90, 217));
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);

        Font font = new Font("宋体",Font.BOLD,20);

        ImgPan imgPanel = new ImgPan();
        imgPanel.setLayout(null);
        imgPanel.setImgPath("bg1.jpg");
        imgPanel.setBounds(550, 200, 800, 600);

        text = new JLabel("账号");
        text.setFont(font);
        text.setPreferredSize(new Dimension(200,80));
        text.setBounds(250,200,200,20);

        pass = new JLabel("密码");
        pass.setFont(font);
        pass.setPreferredSize(new Dimension(200,80));
        pass.setBounds(250,300,200,20);

        textField = new JTextField();
        textField.setOpaque(false);
        textField.setPreferredSize(new Dimension(200,80));
        textField.setBounds(350,200,200,25);

        passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setPreferredSize(new Dimension(200,80));
        passwordField.setBounds(350,300,200,25);

        loginBtn = new NewButton();
        loginBtn.setPreferredSize(new Dimension(200, 80));
        loginBtn.setBgIcon("btn.png");
        loginBtn.setFocusPainted(false);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);
        loginBtn.setBounds(250, 400, 50, 50);

        logoutBtn = new NewButton();
        logoutBtn.setPreferredSize(new Dimension(200, 80));
        logoutBtn.setBgIcon("logout.png");
        logoutBtn.setFocusPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.addActionListener(this);
        logoutBtn.setBounds(500, 400, 50, 50);

        imgPanel.add(pass);
        imgPanel.add(text);
        imgPanel.add(loginBtn);
        imgPanel.add(textField);
        imgPanel.add(passwordField);
        imgPanel.add(logoutBtn);
        shadePanel.add(imgPanel);
        add(shadePanel);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutBtn) {
            System.exit(0);
        }

        if (e.getSource() == loginBtn) {
            JOptionPane.showMessageDialog(shadePanel,"失败");
        }
    }
}

//渐变背景
class ShadePan extends JPanel {
    private Color color1;
    private Color color2;

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    @Override
    protected void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        GradientPaint paint = new GradientPaint(0, 0, color1, 0, height, color2);
        g.setPaint(paint);
        g.fillRect(0, 0, width, height);
    }
}

//图
class ImgPan extends JPanel {
    private String imgPath;

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/thread-study/src/img/" + imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}

//按钮
class NewButton extends JButton {
    private String bgIcon;

    public void setBgIcon(String bgIcon) {
        this.bgIcon = bgIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/thread-study/src/img/" + bgIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}