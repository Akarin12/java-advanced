package com.soft1841.set.work;

import java.util.*;

public class BookCollectionTest {
    public static void main(String[] args) {
        //创建list并加入数据
        List<Book> list = new ArrayList<>();
        list.add(new Book("士大夫与卢卡斯",22.3));
        list.add(new Book("他改变了中国",22.5));
        list.add(new Book("大苏打撒阿斯顿",114.0));
        list.add(new Book("奥迪看到烦烦烦",55.6));
        list.add(new Book("尔萨防护网确认",63.0));
        //创建set
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        Map<Integer,String> map = new HashMap<>();
        Object[] array = set.toArray();
        for (int i =0,len = array.length;i<len;i++){
            map.put(Integer.parseInt(array[i].toString()),list.get(i).getName());
        }

        System.out.println("ID\t\t\t\t书名\t\t\t\t价格");
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.print(entry.getKey()+"\t\t\t"+entry.getValue() +"\t\t\t"+list.get(entry.getKey()-1).getPrice());
            System.out.println();
        }
        }

    }