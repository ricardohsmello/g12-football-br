
import { Component, OnInit } from '@angular/core';

import { KeycloakService } from 'keycloak-angular';
import { MatDialog } from '@angular/material/dialog';
import { Match } from '../../../../domain/model/match/match';
import { MatchService } from '../../../../services/match-service/match.service';
import { MatchAddComponent } from '../../add/match-add.component';
import { MatchResponse } from '../../../../domain/model/match/match-response';
 

@Component({
  selector: 'app-match-list',
  templateUrl: './match-list.component.html',
  styleUrls: ['./match-list.component.scss']
})
export class MatchListComponent implements OnInit {

  matchs: Match[];
  matchResponse: MatchResponse[];

  constructor(
    private matchService: MatchService,
    private readonly keycloak: KeycloakService,
    public dialog: MatDialog) {
  }

  public hasAdminRole: boolean = false;
  name?: string;

  async ngOnInit() {
    this.hasAdminRole = this.keycloak.getUserRoles().includes('admin');
    this.findByRound(1);
  }

  public add() {

    const dialogRef = this.dialog.open(MatchAddComponent, {
      data: { name: this.name },
    })

    dialogRef.afterClosed().subscribe(async result => {      
      (await this.matchService.save(result)).subscribe( result =>
        console.log('aqui')
        );      
    }    
    );

    dialogRef.afterClosed().subscribe(async result => {
      if (result === true) {
      this.findByRound(1);
      }
    });
  }

  private findByRound(round: number) {
     this.matchService.findAllByRound(round).subscribe(data => {
      console.log(data)
      this.matchResponse = data;
    });
  }
}