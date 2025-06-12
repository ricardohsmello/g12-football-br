import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { Match } from '../../../domain/model/match/match';
import { MatchService } from '../../../services/match-service/match.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-match-add',
  templateUrl: './match-add.component.html',
  styleUrls: ['./match-add.component.scss']
})
export class MatchAddComponent implements OnInit {
  roundFormGroup = this._formBuilder.group({
    roundCtrl: ['', Validators.required],
  });
  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  });
  thirdFormGroup = this._formBuilder.group({
    thirdCtrl: ['', Validators.required],
    fourthCtrl: ['', Validators.required],
  });
  isLinear = false;

  teams: String[];
  rounds: number[];

  constructor(private _formBuilder: FormBuilder, private matchService: MatchService, private snackBar: MatSnackBar,
    private dialogRef: MatDialogRef<MatchAddComponent>
  ) {
  }

  ngOnInit(): void {
    this.teams = [
      "Atlético Mineiro",
      "Bahia",
      "Botafogo",
      "Ceará",
      "Corinthians",
      "Cruzeiro",
      "Fortaleza",
      "Flamengo",
      "Fluminense",
      "Grêmio",
      "Internacional",
      "Juventude",
      "Mirassol",
      "Palmeiras",
      "Redbull Bragantino",
      "Santos",
      "São Paulo",
      "Sport",
      "Vasco da Gama",
      "Vitória"
    ];

    this.rounds = Array.from({ length: 38 }, (_, i) => i + 1);
  }

  public save() {
    const match = new Match();
    match.status = "OPEN";
    match.round = Number(this.roundFormGroup.value.roundCtrl);
    match.homeTeam = this.firstFormGroup.value.firstCtrl;
    match.awayTeam = this.secondFormGroup.value.secondCtrl;

    const dateString: string = this.thirdFormGroup.value.thirdCtrl;
    const timeString: string = this.thirdFormGroup.value.fourthCtrl;

    // match.matchDate = new Date(dateString);
    const [hours, minutes] = timeString.split(':').map(Number);

    
    const date = new Date(dateString);

    date.setHours(hours);
    date.setMinutes(minutes);
    date.setSeconds(0);
    date.setMilliseconds(0);

    // Atribui ao match
    match.matchDate = date;

    this.matchService.save(match).subscribe({
      next: () => {
        this.snackBar.open('Match saved successfully!', '', { duration: 3000 });
        this.dialogRef.close(true);
      },
      error: (error) => {
        if (error.error && error.error.message) {
          this.snackBar.open(error.error.message, '', { duration: 4000 });
        } else {
          this.snackBar.open('Unexpected error occurred.', '', { duration: 4000 });
        }
      }
    })

  }

  private buildMatchDate(dateString: string, timeString: string): Date {
    const date = new Date(dateString);
    const [hours, minutes] = timeString.split(':').map(Number);

    return new Date(Date.UTC(
      date.getFullYear(),
      date.getMonth(),
      date.getDate(),
      hours,
      minutes,
      0
    ));
  }
}


