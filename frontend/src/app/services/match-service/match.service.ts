import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Match } from '../../domain/model/match/match';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

  private matchURL: string;

  constructor(private http: HttpClient) {
    this.matchURL = 'http://localhost:8080/match/table';
  }

  public findAll(): Observable<Match[]> {
    return this.http.get<Match[]>(this.matchURL);
  }

  public save(match: Match) {
    return this.http.post<Match>(this.matchURL, match);
  }
}