package br.com.g12.port;

import br.com.g12.model.Match;

public interface MatchPort {
    Match save(Match match);
    Match find(String id);
}
