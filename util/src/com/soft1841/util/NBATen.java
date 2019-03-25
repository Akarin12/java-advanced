package com.soft1841.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * NBA历史十大巨星
 * p229拓展训练1
 *
 * @author Yue Tang
 */
public class NBATen {
    public static void main(String[] args) {
        System.out.println("————————————NBA历史十大巨星————————————");
        List<NBAPlayer> list = new ArrayList<>();
        list.add(new NBAPlayer("乔  丹", "飞 人/神", 30.1, 6.2, 5.3));
        list.add(new NBAPlayer("拉塞尔", "指 环 王", 15.1, 22.5, 4.3));
        list.add(new NBAPlayer("贾巴尔", " 天  钩 ", 24.6, 11.2, 3.6));
        System.out.println(" 球员        " + "绰号      " + "得分     "  + "篮板     " + "助攻");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getPlayer() + "     " + list.get(i).getNickname() + "     " + list.get(i).getScore() + "     " + list.get(i).getRebound() + "     " + list.get(i).getAssist());
            System.out.println();
        }

        System.out.println("用itrater输出");
        Iterator<NBAPlayer> iterator = list.iterator();
        while (iterator.hasNext()){
            NBAPlayer player = iterator.next();
            System.out.println(player.getPlayer() + player.getNickname());
        }


        System.out.println("Lambda");
        list.forEach(nbaPlayer -> System.out.println(nbaPlayer.getPlayer()));


    }
}
