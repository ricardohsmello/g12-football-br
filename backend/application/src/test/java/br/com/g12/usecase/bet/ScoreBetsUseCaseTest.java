package br.com.g12.usecase.bet;

import br.com.g12.fake.BetFake;
import br.com.g12.fake.MatchFake;
import br.com.g12.model.Bet;
import br.com.g12.model.Match;
import br.com.g12.port.BetPort;
import br.com.g12.port.MatchPort;
import br.com.g12.service.ScoringService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ScoreBetsUseCaseTest {

    private final MatchPort matchPort = mock(MatchPort.class);
    private final BetPort betPort = mock(BetPort.class);
    private final ScoringService scoringService = mock(ScoringService.class);

    @Test
    public void should_score_points_correctly() {
        Match match = MatchFake.builder().score(new br.com.g12.model.Score(2, 1)).build();
        Bet bet = BetFake.builder()
                .setId("1")
                .build();

        Bet bet2 = BetFake.builder()
                .setId("2")
                .build();

        List<Match> matches = List.of(match);
        List<Bet> bets = List.of(bet, bet2);

        when(matchPort.findByRound(1)).thenReturn(matches);
        when(betPort.findByMatchId(match.getId())).thenReturn(bets);
        when(scoringService.calculate(eq(match), eq(bet), anyList())).thenReturn(10);

        ScoreBetsUseCase useCase = new ScoreBetsUseCase(matchPort, betPort, scoringService);

        useCase.execute(1);

        verify(betPort).save(bet);
        verify(scoringService, times(2)).calculate(any(), any(), anyList());
    }


}
