package br.com.g12.usecase.bet;

import br.com.g12.model.Bet;
import br.com.g12.model.Match;
import br.com.g12.port.BetPort;
import br.com.g12.port.MatchPort;
import br.com.g12.service.ScoringService;

import java.util.List;

public class ScoreBetsUseCase {

    private final MatchPort matchPort;
    private final BetPort betPort;
    private final ScoringService scoringService;

    public ScoreBetsUseCase(final MatchPort matchPort, final BetPort betPort, ScoringService scoringService) {
        this.matchPort = matchPort;
        this.betPort = betPort;
        this.scoringService = scoringService;
    }

    public void execute(int round) {
        List<Match> matches = matchPort.findByRound(round);

        for (Match match : matches) {
            //addValidator

            if (match.getScore() == null) continue;

            List<Bet> bets = betPort.findByMatchId(match.getId());

            for (Bet bet : bets) {
                List<Bet> otherBets = bets.stream()
                        .filter(b -> !b.getId().equals(bet.getId()))
                        .toList();

                int points = scoringService.calculate(match, bet, otherBets);
                bet.setPointsEarned(points);
                betPort.save(bet);
            }
        }
    }

    }
