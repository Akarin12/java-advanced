package com.soft1841.util;

public class NBAPlayer {
    private String player;
    private String  nickname;
    private Double score;
    private Double rebound;
    private Double assist;

    public NBAPlayer() {
    }

    public NBAPlayer(String player, String nickname, Double score, Double rebound, Double assist) {
        this.player = player;
        this.nickname = nickname;
        this.score = score;
        this.rebound = rebound;
        this.assist = assist;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getRebound() {
        return rebound;
    }

    public void setRebound(Double rebound) {
        this.rebound = rebound;
    }

    public Double getAssist() {
        return assist;
    }

    public void setAssist(Double assist) {
        this.assist = assist;
    }

    @Override
    public String toString() {
        return "NBAPlayer{" +
                "player='" + player + '\'' +
                ", nickname='" + nickname + '\'' +
                ", score=" + score +
                ", rebound=" + rebound +
                ", assist=" + assist +
                '}';
    }
}
