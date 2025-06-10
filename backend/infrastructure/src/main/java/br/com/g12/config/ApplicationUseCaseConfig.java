package br.com.g12.config;

import br.com.g12.port.BetPort;
import br.com.g12.port.MatchPort;
import br.com.g12.service.ScoringService;
import br.com.g12.usecase.bet.CreateBetUseCase;
import br.com.g12.usecase.bet.ScoreBetsUseCase;
import br.com.g12.usecase.match.CreateMatchUseCase;
import br.com.g12.usecase.match.FindMatchesWithUserBetsUseCase;
import br.com.g12.usecase.match.UpdateMatchScoreUseCase;
import br.com.g12.validators.BetValidator;
import br.com.g12.validators.MatchValidator;
import br.com.g12.validators.ScoreValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationUseCaseConfig {

    @Bean
    public MatchValidator matchValidator() {
        return new MatchValidator();
    }

    @Bean
    public ScoreValidator scoreValidator() {
        return new ScoreValidator();
    }

    @Bean
    public BetValidator betValidator() {
        return new BetValidator();
    }

    @Bean
    public CreateMatchUseCase createMatchUseCase(MatchPort matchPort, MatchValidator matchValidator) {
        return new CreateMatchUseCase(matchPort, matchValidator);
    }

    @Bean
    public UpdateMatchScoreUseCase updateMatchScoreUseCase(MatchPort matchPort, MatchValidator matchValidator, ScoreValidator scoreValidator) {
        return new UpdateMatchScoreUseCase(matchPort, matchValidator, scoreValidator);
    }

    @Bean
    public CreateBetUseCase createBetUseCase(BetPort betPort, BetValidator betValidator) {
        return new CreateBetUseCase(betPort, betValidator);
    }

    @Bean
    public ScoreBetsUseCase scoreBetsUseCase(MatchPort matchPort, BetPort betPort, ScoringService scoringService) {
        return new ScoreBetsUseCase(matchPort, betPort, scoringService);
    }

    @Bean
    public FindMatchesWithUserBetsUseCase findMatchesWithUserBets(MatchPort matchPort) {
        return new FindMatchesWithUserBetsUseCase(matchPort);
    }

}
