package br.com.g12.fake;

import br.com.g12.model.Bet;
import br.com.g12.model.Score;

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
}


