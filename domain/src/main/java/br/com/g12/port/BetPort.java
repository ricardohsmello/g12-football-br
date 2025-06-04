package br.com.g12.port;

import br.com.g12.model.Bet;

public interface BetPort {

    Bet save(Bet bet);
    Bet find(String id);
}
