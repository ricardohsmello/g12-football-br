package br.com.g12.response;

import br.com.g12.model.Match;
import br.com.g12.model.Score;

import java.util.Date;

public record MatchResponse(
        String id,
        int round,
        String homeTeam,
        String awayTeam,
        Date matchDate,
        Score score
) {
    public static MatchResponse fromModel(Match match) {
        return new MatchResponse(match.getId(), match.getRound(), match.getHomeTeam(), match.getAwayTeam(), match.getMatchDate(), match.getScore());
    }
}

