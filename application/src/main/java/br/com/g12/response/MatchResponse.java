package br.com.g12.response;

import br.com.g12.model.Match;

import java.util.Date;

public record MatchResponse(
        String id,
        int round,
        String homeTeam,
        String awayTeam,
        Date matchDate
) {
    public static MatchResponse fromModel(Match match) {
        return new MatchResponse(match.getId(), match.getRound(), match.getHomeTeam(), match.getAwayTeam(), match.getMatchDate());
    }
}

