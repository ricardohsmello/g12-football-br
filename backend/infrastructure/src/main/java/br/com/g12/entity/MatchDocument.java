package br.com.g12.entity;

import br.com.g12.model.Match;
import br.com.g12.model.Score;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "match")
public class MatchDocument {
    private String id;
    private int round;
    private String homeTeam;
    private String awayTeam;
    private Date matchDate;
    private Score score;

    public MatchDocument() {}

    public MatchDocument(String id, int round, String homeTeam, String awayTeam, Date matchDate, Score score) {
        this.id = id;
        this.round = round;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDate = matchDate;
        this.score = score;
    }

    public static MatchDocument fromModel(Match match) {
        return new MatchDocument(
                match.getId(),
                match.getRound(),
                match.getHomeTeam(),
                match.getAwayTeam(),
                match.getMatchDate(),
                match.getScore()
        );
    }

    public Match toModel() {
        return new Match(id, round, homeTeam, awayTeam, matchDate, score);
    }
}
