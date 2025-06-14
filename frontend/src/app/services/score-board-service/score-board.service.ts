 import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/environment';

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
    this.scoreBoardURL = `${environment.apiUrl}/scoreboard`;
  }
 
  getByRound(round: number): Observable<ScoreboardEntry[]> {
    return this.http.get<ScoreboardEntry[]>(`${this.scoreBoardURL}?round=${round}`);
  }

}


