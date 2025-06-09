package br.com.g12.model;

public class Bet {
    private String id;
    private String matchId;
    private String username;
    private Score prediction;
    private int round;
    private Integer pointsEarned;

    public Bet(String id, String matchId, String username, Score prediction, int round, Integer pointsEarned) {
        this.id = id;
        this.matchId = matchId;
        this.username = username;
        this.prediction = prediction;
        this.round = round;
        this.pointsEarned = pointsEarned;
    }

    public String getId() { return id; }
    public String getMatchId() { return matchId; }
    public String getUsername() { return username; }
    public Score getPrediction() { return prediction; }
    public int getRound() { return round; }

    public Integer getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Integer pointsEarned) {
        this.pointsEarned = pointsEarned;
    }
}
