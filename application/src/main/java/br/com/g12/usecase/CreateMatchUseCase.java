package br.com.g12.usecase;

import br.com.g12.model.Match;
import br.com.g12.port.MatchPort;
import br.com.g12.request.MatchRequest;
import br.com.g12.response.MatchResponse;
import br.com.g12.validators.MatchValidator;

public class CreateMatchUseCase {

    private final MatchValidator validator;
    private final MatchPort matchPort;

    public CreateMatchUseCase(MatchPort matchPort, MatchValidator validator) {
        this.matchPort = matchPort;
        this.validator = validator;
    }

    public MatchResponse execute(MatchRequest matchRequest) {
        Match match = matchRequest.toModel();

        validator.validate(match);
        Match save = matchPort.save(match);

        return MatchResponse.fromModel(save);
    }
}
