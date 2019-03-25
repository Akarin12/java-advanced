package com.soft1841;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<String> set = new TreeSet<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        //1、录入信息（map集合）
        map.put("张三\t\t12883", 666);
        map.put("李四\t\t23212", 843);
        map.put("小兰\t\t12313", 732);
        map.put("小红\t\t12314", 956);
        map.put("白白\t\t12318", 512);
        map.put("兰兰\t\t12332", 944);
        //2、遍历输出所有信息（map集合调动entry方法后，foreach遍历输出）
        Set<Map.Entry<String, Integer>> ent = map.entrySet();
        System.out.println("姓名"+"\t\t"+"会员号"+"\t\t"+"积分");
        for(Map.Entry<String, Integer> e:ent) {
            list.add(e.getValue());
            //输出所有会员的积分（按录入顺序输出，未排序）
            System.out.println(e.getKey()+"\t\t"+e.getValue());
        }


        //3、输出分数前三名的会员信息，集合的工具类进行排序
        Collections.sort(list);
        System.out.println("积分前三名：");
        //输出前三名的成绩（成绩由高到低的输出）
        for(int i=1;i<=3;i++) {
            //遍历map集合
            for(Map.Entry<String, Integer> e:ent) {
                //获取前三名的号
                if(list.get(list.size()-i)==e.getValue()) {
                    set.add(e.getKey());
                    System.out.println(e.getKey()+"\t\t"+e.getValue());
                }
            }
        }
    }
}
