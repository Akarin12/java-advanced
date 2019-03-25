package com.soft1841.util;

import java.util.Random;

/**
 * 随机数类
 */
public class RandomDemo {
    public static void main(String[] args) {
        //随机生成一个5以内的数
        Random random = new Random();
        //[0,bound)
        int num = random.nextInt(6);

    }
}
