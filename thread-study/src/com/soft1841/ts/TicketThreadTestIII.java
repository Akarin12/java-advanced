package com.soft1841.ts;

/**
 * 实现runnable并同步线程(加密)
 */
public class TicketThreadTestIII {
    public static void main(String[] args) {
        TicketThreadIII tt = new TicketThreadIII();
        Thread thread1 = new Thread(tt, "窗口1");
        thread1.start();
        Thread thread2 = new Thread(tt, "窗口2");
        thread2.start();
    }
}

class TicketThreadIII implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {

        while (true) {
            //同步售票代码块
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票,当前票数" + --tickets);
                    try {
                        Thread.sleep(900);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                } else {
                    break;
                }
            }
        }
    }
}