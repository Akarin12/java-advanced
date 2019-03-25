package com.soft1841.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * List接口练习
 */
public class ListTest {
    public static void main(String[] args) {
        //创建一个List接口对象，元素为string
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("B");
        System.out.println(list);
        System.out.println(list.indexOf("B"));
        System.out.println(list.lastIndexOf("B"));


//        //用util的Random类随机产生一个[0,List.size()-1]的随机数
//        int length = list.size();
//        Random random = new Random();
//        int index = random.nextInt(length);
//        //取出List中索引为index的元素
//        System.out.println(list.get(index));
//        //输出所有List元素
//        for (int i = 0; i < length; i++
//        ) {
//            System.out.println(list.get(i));
//        }


    }
}
