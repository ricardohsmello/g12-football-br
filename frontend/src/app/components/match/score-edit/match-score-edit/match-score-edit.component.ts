import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-match-score-edit',
  templateUrl: './match-score-edit.component.html'
})
export class MatchScoreEditComponent {
  homeTeamScore: number;
  awayTeamScore: number;

  constructor(
    public dialogRef: MatDialogRef<MatchScoreEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any

  ) {}

  submit(): void {
    this.dialogRef.close({
      homeTeam: this.homeTeamScore,
      awayTeam: this.awayTeamScore
    });
  }
}
