package br.com.g12.config;

import br.com.g12.port.MatchPort;
import br.com.g12.usecase.CreateMatchUseCase;
import br.com.g12.usecase.UpdateMatchScoreUseCase;
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
    public CreateMatchUseCase matchUseCase(MatchPort matchPort, MatchValidator matchValidator) {
        return new CreateMatchUseCase(matchPort, matchValidator);
    }

    @Bean
    public UpdateMatchScoreUseCase updateMatchScoreUseCase(MatchPort matchPort, MatchValidator matchValidator, ScoreValidator scoreValidator) {
        return new UpdateMatchScoreUseCase(matchPort, matchValidator, scoreValidator);
    }
}
