import { Score } from "../score/score"

export class MatchResponse {
   id: string;
   round: number;
   homeTeam: string;
   awayTeam: string;
   matchDate: Date;
   score: Score;
   prediction: Score;
   pointsEarned: number;
   status: string;
}
