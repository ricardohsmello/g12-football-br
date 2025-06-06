import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Team } from '../../domain/model/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private teamUrl: string;

  constructor(private http: HttpClient) {
    this.teamUrl = 'http://localhost:8080/team';
  }

  public findAll(): Observable<Team[]> {
    return this.http.get<Team[]>(this.teamUrl);
  }

  public save(team: Team) {
    return this.http.post<Team>(this.teamUrl, team);
  }
}