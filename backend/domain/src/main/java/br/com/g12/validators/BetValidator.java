package br.com.g12.validators;

import br.com.g12.exception.BetException;
import br.com.g12.exception.NotFoundException;
import br.com.g12.model.Bet;
import br.com.g12.model.Score;

public class BetValidator {

    public void validate(Bet bet) {
        if (bet == null) {
            throw new NotFoundException("Bet");
        }

        if (bet.getMatchId() == null || bet.getMatchId().isBlank()) {
            throw new BetException("Match ID is required");
        }

        if (bet.getUserId() == null || bet.getUserId().isBlank()) {
            throw new BetException("User ID is required");
        }

        if (bet.getPrediction() == null) {
            throw new BetException("Score prediction must be provided");
        }

        validateScore(bet.getPrediction());

        if (bet.getRound() < 1 || bet.getRound() > 38) {
            throw new BetException("Round must be between 1 and 38");
        }
    }

    private void validateScore(Score score) {
        if (score.homeTeam() < 0 || score.awayTeam() < 0) {
            throw new BetException("Score cannot be negative");
        }
    }
}
