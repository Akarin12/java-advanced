package com.soft1841.util;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 随机颜色
 */
public class RandomColor {
    public static void main(String[] args) throws IOException {
        Random random = new Random();

        //绘制图片
        //在图片缓冲区生成图片对象 指定图片大小类型
        BufferedImage bufferedImage = new BufferedImage(120,40,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置字体
        Font font = new Font("微软雅黑",Font.BOLD,16);
        g.setFont(font);

        //绘制,充满
        g.fillRect(0,0,120,40);
        //字的颜色
        g.setColor(Color.black);
        //创建字母及数字的数组
        char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertyuiopasdfghjklzxcvbnm".toCharArray();
        int len=ch.length;
        int letter;
        //循环输出字
        for(int i=0;i<4;++i){
            letter=random.nextInt(len);
            //画出对应随机的验证码字符
            g.drawString(ch[letter]+"",(i*20)+15,20);
        }

        //生成干扰线
        for(int i = 0; i < 15;i++) {
            //随机颜色
            int redRandom = random.nextInt(256);
            int greenRandom = random.nextInt(256);
            int blueRandom = random.nextInt(256);
            //随机坐标
            int x1 = random.nextInt(120);
            int y1 = random.nextInt(40);
            int x2 = random.nextInt(120);
            int y2 = random.nextInt(40);
            Color color = new Color(redRandom, greenRandom, blueRandom);
            g.setColor(color);
            g.drawLine(x1,y1,x2,y2);
        }

        //输出
        File file = new File("D:/code.jpg");
        //获取输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片写到文件
        ImageIO.write(bufferedImage,"jpg",outputStream);
        //关闭输出流
        outputStream.close();
    }
}
