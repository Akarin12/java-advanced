package com.soft1841.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //for循环遍历集合
        for(int i =0,len = list.size();i<len;i++){
            System.out.println(list.get(i));
        }
        System.out.println();
        //itenerator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        //Lambda
        list.forEach(s -> System.out.println(s) );

    }
}
