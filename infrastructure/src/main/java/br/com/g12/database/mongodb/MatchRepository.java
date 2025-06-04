package br.com.g12.database.mongodb;

import br.com.g12.entity.MatchDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<MatchDocument, String> {


}
