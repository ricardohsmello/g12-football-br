package br.com.g12.database.mongodb;

import com.mongodb.client.MongoClients;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
public class SimpleMongoTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0");

    @Test
    void should_insert_and_read_document() {
        try (var mongoClient = MongoClients.create(mongoDBContainer.getReplicaSetUrl())) {
            MongoTemplate template = new MongoTemplate(mongoClient, "testdb");

            Person person = new Person("Ricardo", 30);
            template.save(person);

            long count = template.count(Query.query(Criteria.where("name").is("Ricardo")), Person.class);
            assertEquals(1, count);
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
