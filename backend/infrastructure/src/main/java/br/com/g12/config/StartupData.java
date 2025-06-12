package br.com.g12.config;

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

            var round = 12;

//            createRound(round, "Redbull Bragantino", "Bahia", null, matchPort, betPort);
//            createRound(round, "Vitória", "Cruzeiro", null, matchPort, betPort);
//            createRound(round, "Fortaleza", "Santos", null, matchPort, betPort);
//            createRound(round, "Grêmio", "Corinthians", null, matchPort, betPort);
//            createRound(round, "São Paulo", "Vasco da Gama", null, matchPort, betPort);
//            createRound(round, "Atletico Mineiro", "Internacional", null, matchPort, betPort);
//            createRound(round, "Fluminense", "Ceara", null, matchPort, betPort);
//            createRound(round, "Botafogo", "Mirassol", null, matchPort, betPort);
//            createRound(round, "Palmeiras", "Juventude", null, matchPort, betPort);
//            createRound(round, "Sport", "Flamengo", null, matchPort, betPort);
//
//            System.out.println("Matches and bets initialized");


        };
    }

    private void createRound(int round, String homeTeam, String awayTeam, Score matchScore, MatchPort matchPort, BetPort betPort) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Match match1 = new Match(null, round, homeTeam, awayTeam, sdf.parse("2025-06-12"), matchScore, "Open");
//        Match match2 = new Match(null, round, homeTeam, awayTeam, sdf.parse("2025-06-12"), matchScore);

         matchPort.save(match1);

//        Bet betRic1 = new Bet(null, match1.getId(), "Ricardo", new Score(2, 1), round, null);
//        Bet betRic2 = new Bet(null, match2.getId(), "Ricardo", new Score(1, 1), round, null);
//
//        Bet betDani1 = new Bet(null, match1.getId(), "Daniel", new Score(4, 0), round, null);
//        Bet betDani2 = new Bet(null, match2.getId(), "Daniel", new Score(0, 2), round, null);
//
//        Bet betBau1 = new Bet(null, match1.getId(), "Braulio", new Score(3, 1), round, null);
//        Bet betBau2 = new Bet(null, match2.getId(), "Braulio", new Score(1, 0), round, null);



    }
}
