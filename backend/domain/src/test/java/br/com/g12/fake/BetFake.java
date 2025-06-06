package br.com.g12.fake;

import br.com.g12.model.Bet;
import br.com.g12.model.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BetFake {

    public static BetBuilder builder() {
        return new BetBuilder();
    }

    public static class BetBuilder {
        private String id;
        private String matchId;
        private String userId;
        private Score prediction;
        private int round;
        private Integer pointsEarned;

        public BetBuilder id(String id) {
            this.id = id;
            return this;
        }
        public BetBuilder matchId(String matchId) {
            this.matchId = matchId;
            return this;
        }
        public BetBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }
        public BetBuilder prediction(Score prediction) {
            this.prediction = prediction;
            return this;
        }
        public BetBuilder round(int round) {
            this.round = round;
            return this;
        }

        public BetBuilder pointsEarned(Integer pointsEarned) {
            this.pointsEarned = pointsEarned;
            return this;
        }
        public Bet build() {
            return new Bet(id, matchId, userId, prediction, round, pointsEarned);
        }

    }
    public static class BetListBuilder {
        private final List<Bet> bets = new ArrayList<>();
        private final String matchId;

        public BetListBuilder(String matchId) {
            this.matchId = matchId;
        }

        public BetListBuilder add(String userId, Score prediction) {
            bets.add(new Bet(UUID.randomUUID().toString(), matchId, userId, prediction, 1, null));
            return this;
        }

        public List<Bet> build() {
            return bets;
        }
    }
}


