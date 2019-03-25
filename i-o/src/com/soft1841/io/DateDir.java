package com.soft1841.io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class DateDir {
    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int mouth = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        int minute = calendar.get(calendar.MINUTE);
        int second = calendar.get(calendar.SECOND);
        String dir = year + "-" + mouth + "-" + day;
        String path = "F:/";
        File folder = new File(path + "/" + dir);
        folder.mkdirs();
        File file = new File(folder + "/" + "hello_" + hour + "-" + minute + "-" + second + ".txt");
        file.createNewFile();
    }
}
