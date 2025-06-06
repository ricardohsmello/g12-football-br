package br.com.g12.config;

import br.com.g12.model.Bet;
import br.com.g12.model.Match;
import br.com.g12.model.Score;
import br.com.g12.port.BetPort;
import br.com.g12.port.MatchPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Configuration
public class StartupData {

    @Bean
    public CommandLineRunner loadData(MatchPort matchPort, BetPort betPort) {
        return args -> {

            createRound(1, "Corinthians", "Santos", new Score(2, 1), matchPort, betPort);
            createRound(1, "São Paulo", "Grêmio", new Score(2, 2), matchPort, betPort);


            createRound(2, "Gremio", "Corinthians", null, matchPort, betPort);
            createRound(2, "Santos", "São Paulo", null, matchPort, betPort);

        };
    }

    private void createRound(int round, String homeTeam, String awayTeam, Score matchScore, MatchPort matchPort, BetPort betPort) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Match match1 = new Match(null, round, homeTeam, awayTeam, sdf.parse("2025-10-10"), matchScore);
        Match match2 = new Match(null, round, homeTeam, awayTeam, sdf.parse("2025-10-11"),matchScore);

        match1 = matchPort.save(match1);
        match2 = matchPort.save(match2);

        Bet betRic1 = new Bet(null, match1.getId(), "Ricardo", new Score(2, 1), round, null);
        Bet betRic2 = new Bet(null, match2.getId(), "Ricardo", new Score(1, 1), round, null);

        Bet betDani1 = new Bet(null, match1.getId(), "Daniel", new Score(4, 0), round, null);
        Bet betDani2 = new Bet(null, match2.getId(), "Daniel", new Score(0, 2), round, null);

        Bet betBau1 = new Bet(null, match1.getId(), "Braulio", new Score(3, 1), round, null);
        Bet betBau2 = new Bet(null, match2.getId(), "Braulio", new Score(1, 0), round, null);

        betPort.save(betRic1);
        betPort.save(betRic2);

        betPort.save(betDani1);
        betPort.save(betDani2);

        betPort.save(betBau1);
        betPort.save(betBau2);

        System.out.println("Matches and bets initialized");
    }
}
