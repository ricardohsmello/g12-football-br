import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Bet } from '../../domain/model/bet/bet' 
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})export class BetService {

  private betURL: string;

  constructor(private http: HttpClient) {
    this.betURL = `${environment.apiUrl}`;
  }

  public save(bet: Bet) {
    console.log(this.betURL);
    return this.http.post<Bet>(this.betURL, bet);
  }
}