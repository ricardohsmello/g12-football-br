package br.com.g12.response;

import br.com.g12.model.Match;
import br.com.g12.model.MatchWithPrediction;
import br.com.g12.model.Score;

import java.util.Date;

public record MatchResponse(
        String id,
        int round,
        String homeTeam,
        String awayTeam,
        Date matchDate,
        Score score,
        Score prediction
) {
    public static MatchResponse fromModel(Match match) {
        return new MatchResponse(match.getId(), match.getRound(), match.getHomeTeam(), match.getAwayTeam(), match.getMatchDate(), match.getScore(), null);
    }

    public static MatchResponse fromModel(MatchWithPrediction match) {
        return new MatchResponse(match.getId(), match.getRound(), match.getHomeTeam(), match.getAwayTeam(), match.getMatchDate(), match.getScore(), match.getPrediction());
    }
}

