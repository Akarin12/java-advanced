package com.soft1841.ts;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {
    public static void main(String[] args) {
        TimerTask task0 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };


        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("nmsl");
            }
        };
        Timer timer = new Timer();
        timer.schedule(task0, 0, 1000);
        timer.schedule(task1, 0, 500);
    }
}
