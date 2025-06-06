 import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Scoreboard } from '../../domain/model/score-board/scoreboard';

@Injectable({
  providedIn: 'root'
})
export class ScoreBoardService {

  private scoreBoardURL: string;

  constructor(private http: HttpClient) {
    this.scoreBoardURL = 'http://localhost:8080/score/table';
  }

  public findAll(): Observable<Scoreboard[]> {
    return this.http.get<Scoreboard[]>(this.scoreBoardURL);
  }

  // public save(user: User) {
  //   return this.http.post<User>(this.usersUrl, user);
  // }
}