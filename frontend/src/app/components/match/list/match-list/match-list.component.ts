
import { Component, OnInit } from '@angular/core';

import { KeycloakService } from 'keycloak-angular';
import { MatDialog } from '@angular/material/dialog';
import { Match } from '../../../../domain/model/match/match';
import { MatchService } from '../../../../services/match-service/match.service';
import { MatchAddComponent } from '../../add/match-add.component';
import { MatchResponse } from '../../../../domain/model/match/match-response';
import { FormBuilder, Validators } from '@angular/forms';
import { MatchScoreEditComponent } from '../../score-edit/match-score-edit/match-score-edit.component';
import { MatchBetEditComponent } from '../../bet-edit/match-bet-edit/match-bet-edit.component';
import { BetService } from '../../../../services/bet-service/bet.service';
// import { MatSnackBar } from '@angular/material/snack-bar';
// import { MatDialogRef } from '@angular/material/dialog';

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
  currentRound: number = 1;
  public hasAdminRole: boolean = false;
  name?: string;
  username: string;

  constructor(
    private matchService: MatchService,
    private readonly keycloak: KeycloakService,
    public dialog: MatDialog,
    private _formBuilder: FormBuilder,
    private betService: BetService
    // private snackBar: MatSnackBar,
    //   private dialogRef: MatDialogRef<MatchAddComponent>
  ) {
  }


  openEditBetDialog(match: MatchResponse): void {

    const dialogRef = this.dialog.open(MatchBetEditComponent, {
      width: '300px',
      data: { match },
    });

    dialogRef.afterClosed().subscribe(result => {
    
       if (result) {
      this.keycloak.loadUserProfile().then(profile => {
        const payload = {
          matchId: match.id,
          username: profile.username ?? profile.email ?? 'unknown',
          prediction: {
            homeTeam: result.homeTeam,
            awayTeam: result.awayTeam
          },
          round: match.round
        };

        console.log(payload);

        this.betService.save(payload).subscribe(() => {
          this.findByUsernameRound(this.username, this.currentRound);
        });
      });
    }
  });
}      
 
      
  openEditScoreDialog(match: MatchResponse): void {
    const dialogRef = this.dialog.open(MatchScoreEditComponent, {
      width: '300px',
      data: { match },
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        //     this.matchService.updateScore(match.id, result).subscribe({
        //   next: () => {
        //     this.snackBar.open('Match score added successfully!', '', { duration: 3000 });
        //     this.dialogRef.close(true);
        //     this.findByRound(this.currentRound);
        //   },
        //   error: (error) => {
        //     if (error.error && error.error.message) {
        //       this.snackBar.open(error.error.message, '', { duration: 4000 });
        //     } else {
        //       this.snackBar.open('Unexpected error occurred.', '', { duration: 4000 });
        //     }
        //   }
        // })


        this.matchService.updateScore(match.id, result).subscribe(() => {
          this.findByUsernameRound(this.username, this.currentRound);
        });
      }
    });
  }

  async ngOnInit() {
    this.keycloak.loadUserProfile().then(profile => {
        this.username = profile.username ?? profile.email ?? 'unknown'

        this.rounds = Array.from({ length: 38 }, (_, i) => i + 1);

        this.hasAdminRole = this.keycloak.getUserRoles().includes('admin');
        this.findByUsernameRound(this.username, this.currentRound);

        this.roundFormGroup.get('roundCtrl')?.valueChanges.subscribe((round) => {
            const roundNumber = Number(round);
            this.currentRound = Number(round);
            if (!isNaN(roundNumber)) {
              this.findByUsernameRound(this.username, roundNumber);
            }
          });
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
        this.findByUsernameRound(this.username, this.currentRound);
      }
    });
  }

  private findByUsernameRound(username, round: number) {
    this.matchService.findByUsernameRound(username, round).subscribe(data => {
      console.log(data)
      this.matchResponse = data;
    });
  }
}

 
