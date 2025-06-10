package br.com.g12.entity;

import br.com.g12.model.Bet;
import br.com.g12.model.Score;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bet")
public class BetDocument {
    @Id
    private String id;
    private ObjectId matchId;
    private String username;
    private Score prediction;
    private int round;
    private Integer pointsEarned;

    public BetDocument() {}

    public BetDocument(String id, String matchId, String username, Score prediction, int round, Integer pointsEarned) {
        this.id = id;
        this.matchId = new ObjectId(matchId);
        this.username = username;
        this.prediction = prediction;
        this.round = round;
        this.pointsEarned = pointsEarned;
    }

    public static BetDocument fromModel(Bet bet) {
        return new BetDocument(
                bet.getId() != null ? bet.getId() : null,
                bet.getMatchId() != null ? bet.getMatchId() : null,
                bet.getUsername(),
                bet.getPrediction(),
                bet.getRound(),
                bet.getPointsEarned() != null ? bet.getPointsEarned() : null
        );
    }

    public void setPrediction(Score prediction) {
        this.prediction = prediction;
    }

    public Bet toModel() {
        return new Bet(id, matchId.toString(), username, prediction, round, pointsEarned);
    }
}