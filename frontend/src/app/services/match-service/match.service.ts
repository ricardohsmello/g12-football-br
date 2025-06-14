import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Match } from '../../domain/model/match/match';
import { MatchResponse } from '../../domain/model/match/match-response';

@Injectable({
  providedIn: 'root'
})export class MatchService {

  private matchURL: string;

  constructor(private http: HttpClient) {
    this.matchURL = 'https://g12-football-br.onrender.com/match';
  }

  public findByUsernameRound(username: string, round: number): Observable<MatchResponse[]> {
    return this.http.get<MatchResponse[]>(this.matchURL + "/username/" + username + "/round/" + round);
  }

  public findAll(): Observable<Match[]> {
    return this.http.get<Match[]>(this.matchURL);
  }

  public updateScore(matchId: string, score: { homeTeam: number, awayTeam: number }) {
    return this.http.put<void>(this.matchURL + `/${matchId}/score`, score);
  }

  public save(match: Match) {
    console.log(this.matchURL);
    return this.http.post<Match>(this.matchURL, match);
  }

  public scoreRound(round: number) {
    return this.http.put<void>(`https://g12-football-br.onrender.com/rounds/${round}/score`, {});
  }
}