
import { Component, OnInit } from '@angular/core';

import { KeycloakService } from 'keycloak-angular';
import { MatDialog } from '@angular/material/dialog';
import { Match } from '../../../../domain/model/match/match';
import { MatchService } from '../../../../services/match-service/match.service';
import { MatchAddComponent } from '../../add/match-add.component';
import { MatchResponse } from '../../../../domain/model/match/match-response';
import { FormBuilder, Validators } from '@angular/forms';
import { MatchScoreEditComponent } from '../../score-edit/match-score-edit/match-score-edit.component';


@Component({
  selector: 'app-match-list',
  templateUrl: './match-list.component.html',
  styleUrls: ['./match-list.component.scss']
})
export class MatchListComponent implements OnInit {
 
  roundFormGroup = this._formBuilder.group({
    roundCtrl: this._formBuilder.control(1, Validators.required),
});


  matchs: Match[];
  matchResponse: MatchResponse[];
  rounds: number[];
  currentRound: number=1;

  constructor(
    private matchService: MatchService,
    private readonly keycloak: KeycloakService,
    public dialog: MatDialog,
    private _formBuilder: FormBuilder) {
  }

  openEditScoreDialog(match: MatchResponse): void {
  const dialogRef = this.dialog.open(MatchScoreEditComponent, {
    width: '300px',
    data: { match },
  });

  dialogRef.afterClosed().subscribe(result => {
    if (result) {
      this.matchService.updateScore(match.id, result).subscribe(() => {
        this.findByRound(this.currentRound);
      });
    }
  });
}


  public hasAdminRole: boolean = false;
  name?: string;

  async ngOnInit() {
    this.rounds = Array.from({ length: 38 }, (_, i) => i + 1);


    this.hasAdminRole = this.keycloak.getUserRoles().includes('admin');
    this.findByRound(this.currentRound);
 
    this.roundFormGroup.get('roundCtrl')?.valueChanges.subscribe((round) => {
      const roundNumber = Number(round);
      this.currentRound = Number(round);
      if (!isNaN(roundNumber)) {
        this.findByRound(roundNumber);
      }
    });

  }

  public add() {

    const dialogRef = this.dialog.open(MatchAddComponent, {
      data: { name: this.name },
    })

    dialogRef.afterClosed().subscribe(async result => {
      (await this.matchService.save(result)).subscribe();
    }
    );

    dialogRef.afterClosed().subscribe(async result => {
      if (result === true) {
        this.findByRound(this.currentRound);
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