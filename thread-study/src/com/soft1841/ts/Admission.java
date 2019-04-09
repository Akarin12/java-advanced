package com.soft1841.ts;

public class Admission {
    public static void main(String[] args) {
        System.out.println("A、B两队球员开始入场……");
        A a=new A();
        a.start();
        B b=new B();
        b.start();
    }
}

class A extends Thread {
    public void run() {
        for (int i = 1; i <= 11; i++) {
            System.out.print("a"+ i+"\t");
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 1; i <= 11; i++) {
            System.out.print("b"+ i+"\t");
        }
    }
}