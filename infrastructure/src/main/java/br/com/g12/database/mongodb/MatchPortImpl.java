package br.com.g12.database.mongodb;


import br.com.g12.entity.MatchDocument;
import br.com.g12.model.Match;
import br.com.g12.port.MatchPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MatchPortImpl implements MatchPort {

    private final MatchRepository matchRepository;

    MatchPortImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match save(Match match) {
        MatchDocument matchDocument = MatchDocument.fromModel(match);
        return matchRepository.save(matchDocument).toModel();
    }

    @Override
    public Match find(String id) {
        Optional<MatchDocument> byId = matchRepository.findById(id);
        return byId.map(MatchDocument::toModel).orElse(null);
    }
}
