package br.com.g12.usecase.match;

import br.com.g12.model.Match;
import br.com.g12.model.MatchWithPrediction;
import br.com.g12.port.MatchPort;
import br.com.g12.response.MatchResponse;

import java.util.List;

public class FindMatchesWithUserBetsUseCase {

    private final MatchPort matchPort;

    public FindMatchesWithUserBetsUseCase(final MatchPort matchPort
                                   ) {
        this.matchPort = matchPort;
    }

    public List<MatchResponse> execute(String username, int round) {

        List<MatchWithPrediction> matchWithPredictionList = matchPort.findByRoundUser(username, round);

        return matchWithPredictionList.stream().map(MatchResponse::fromModel).toList();

    }

}
