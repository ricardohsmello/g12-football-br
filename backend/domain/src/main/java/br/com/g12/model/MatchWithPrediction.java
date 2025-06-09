package br.com.g12.model;

import java.util.Date;

public class MatchWithPrediction {
    private String id;
    private int round;
    private String homeTeam;
    private String awayTeam;
    private Date matchDate;
    private Score score;
    private Score prediction;


    public String getId() {
        return id;
    }

    public int getRound() {
        return round;
    }

    public Date getMatchDate() {
        return matchDate;
    }


    public Score getPrediction() {
        return prediction;
    }

    public Score getScore() {
        return score;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }
}