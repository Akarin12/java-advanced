package com.soft1841.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArticleListTest {
    public static void main(String[] args) throws ParseException {
        System.out.println("id           "+"标题"+"            作者"+"       时间");
        List<Article> articleList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        articleList.add(new Article(1919,"感谢这4个自学网站，坚持了一个月，让我从月薪3000涨到10000","陈晨",format.parse("2019-03-17 21:35:26")));
        articleList.add(new Article(14514,"母猪的配种指南以及产后护理","张龙龙",format.parse("2019-02-17 11:55:36")));


        Iterator<Article> iterator = articleList.iterator();
        while (iterator.hasNext()){
            Article article = iterator.next();
            String result;
            result = timeCal(format.format(article.getWriteTime()));
                System.out.println(article.getId()+"    "+article.getTitle().substring(0,10)+"..."+"    "+article.getAuthor()+"    "+result);

        }
    }

    private static String timeCal(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1;
        long diff = 0;
        try {
            d1 = format.parse(time);
            Date now = new Date();
            diff = now.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        if (seconds < 60) {
            return "刚刚";
        } else if (minutes < 60) {
            return minutes + "分钟前";
        } else if (hours < 24) {
            return hours + "小时前";
        } else {
            return days + "天前";
        }
    }
}
