package br.com.g12.port;

import br.com.g12.model.Match;

import java.util.List;

public interface MatchPort {
    Match save(Match match);
    Match find(String id);
    List<Match> findByRound(int round);
}
