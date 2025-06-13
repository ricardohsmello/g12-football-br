 import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

export interface ScoreboardEntry {
  username: string;
  points: number;
}

@Injectable({
  providedIn: 'root'
})
export class ScoreBoardService {

  private scoreBoardURL: string;

  constructor(private http: HttpClient) {
    this.scoreBoardURL =  'http://localhost:8080/scoreboard';
  }
 
  getByRound(round: number): Observable<ScoreboardEntry[]> {
    return this.http.get<ScoreboardEntry[]>(`${this.scoreBoardURL}?round=${round}`);
  }

}


