package br.com.g12.database.mongodb;

import br.com.g12.entity.ScoreboardDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreboardRepository extends MongoRepository<ScoreboardDocument, String> {

    List<ScoreboardDocument> findByRoundOrderByPositionAsc(int round);
}
