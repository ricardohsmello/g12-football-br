import { Score } from "../score/score";

export class Bet {
    matchId: string;    
    username: string;
    prediction: Score;
    round: number;
}
