package com.soft1841.ts;

/**
 * 售票2
 * Runnable
 */
public class TicketThreadTestII {
    public static void main(String[] args) {
        TicketThreadII tt = new TicketThreadII();
        Thread threadI = new Thread(tt);
        threadI.start();
        Thread threadII = new Thread(tt);
        threadII.start();
    }
}

class TicketThreadII implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "售票,当前票数" + --tickets);
        }
    }
}