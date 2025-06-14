import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Bet } from '../../domain/model/bet/bet' 

@Injectable({
  providedIn: 'root'
})export class BetService {

  private betURL: string;

  constructor(private http: HttpClient) {
    this.betURL = 'https://g12-football-br.onrender.com/bet';
  }

  public save(bet: Bet) {
    console.log(this.betURL);
    return this.http.post<Bet>(this.betURL, bet);
  }
}