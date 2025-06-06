package br.com.g12.usecase.match;

import br.com.g12.model.Match;
import br.com.g12.port.MatchPort;
import br.com.g12.response.MatchResponse;

import java.util.List;

public class FindMatchesByRoundUseCase {

    private final MatchPort matchPort;

    public FindMatchesByRoundUseCase(final MatchPort matchPort) {
        this.matchPort = matchPort;
    }

    public List<MatchResponse> execute(int round) {
        List<Match> listMatch = matchPort.findByRound(round);
        return listMatch.stream().map(MatchResponse::fromModel).toList();
    }
}
