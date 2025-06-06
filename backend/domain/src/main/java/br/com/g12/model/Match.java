package br.com.g12.model;

import java.util.Date;

public class Match {
    String id;
    int round;
    String homeTeam;
    String awayTeam;
    Date matchDate;
    Score score;

    public Match(String id, int round, String homeTeam, String awayTeam, Date matchDate, Score score) {
        this.id = id;
        this.round = round;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDate = matchDate;
        this.score = score;
    }

    public String getId() {return id; }

    public int getRound() { return round; }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Date getMatchDate() { return matchDate; }

    public Score getScore() { return score; }

    public void setScore(Score score) {
        this.score = score;
    }
}

