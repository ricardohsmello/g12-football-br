import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-match-bet-edit',
  templateUrl: './match-bet-edit.component.html',
  styleUrls: ['./match-bet-edit.component.scss']
})
export class MatchBetEditComponent {
  homeTeamScore: number;
  awayTeamScore: number;

  constructor(
    public dialogRef: MatDialogRef<MatchBetEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any

  ) {}

  submit(): void {
    this.dialogRef.close({
      homeTeam: this.homeTeamScore,
      awayTeam: this.awayTeamScore
    });
  }
}
