package br.com.g12.usecase.match;


import br.com.g12.exception.MatchException;
import br.com.g12.model.Match;
import br.com.g12.model.Score;
import br.com.g12.port.MatchPort;
import br.com.g12.request.ScoreRequest;
import br.com.g12.usecase.AbstractUseCase;
import br.com.g12.validators.MatchValidator;
import br.com.g12.validators.ScoreValidator;

public class UpdateMatchScoreUseCase extends AbstractUseCase<ScoreRequest> {

    private final MatchPort matchPort;
    private final MatchValidator matchValidator;
    private final ScoreValidator scoreValidator;

    public UpdateMatchScoreUseCase(
            MatchPort matchPort,
            MatchValidator matchValidator,
            ScoreValidator scoreValidator
    ) {
        this.matchPort = matchPort;
        this.matchValidator = matchValidator;
        this.scoreValidator = scoreValidator;
    }

    public void execute(String matchId, ScoreRequest score) {
        logInput(score);

        try {
            Match match = matchPort.find(matchId);
            Score model = score.toModel();

            matchValidator.validate(match);
            scoreValidator.validate(model);

            match.setScore(model);
            matchPort.save(match);

            logSuccess();
        } catch (MatchException e) {
            logError(e);
            throw e;
        }
    }
}