package com.soft1841.ts;

/**
 * 多线程售票程序1
 * 继承Thread类实现
 */
public class TicketThreadTestI {
    public static void main(String[] args) {
        TicketThreadI tt1 = new TicketThreadI();
        tt1.start();
        TicketThreadI tt2 = new TicketThreadI();
        tt2.start();
        TicketThreadI tt3 = new TicketThreadI();
        tt3.start();
    }
}

class TicketThreadI extends Thread {
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "售票,当前票数" + --tickets);
        }
    }
}
