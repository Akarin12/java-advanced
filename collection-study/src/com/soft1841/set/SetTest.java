package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set接口基础程序
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");
        System.out.println(set);
        System.out.println();
//        String s1 = new String("A");
//        String s2 = new String("B");
//        String s3 = new String("C");
//        String s4 = new String("A");
//
//        set.add(s1);
//        set.add(s2);
//        set.add(s3);
//        set.add(s4);
//        System.out.println(set);

        //用for
        Object[] array = set.toArray();
        for (int i=0,len = set.size();i<len;i++){
            System.out.println(array[i]+"  ");
        }
        System.out.println();

        //用iterator
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
            System.out.println();
        }
        System.out.println();
        //用lambda
        System.out.println("lambda");
        set.forEach(s -> System.out.println(s));
    }
}
