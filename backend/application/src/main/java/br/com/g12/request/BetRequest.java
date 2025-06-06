package br.com.g12.request;

import br.com.g12.model.Bet;
import br.com.g12.model.Score;

public record BetRequest(
        String matchId,
        String userId,
        Score prediction,
        int round
) {
    public Bet toModel() {
        return new Bet(null, matchId, userId, prediction, round, null);
    }
}
