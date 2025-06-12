
import { Component, OnInit } from '@angular/core';
import { Scoreboard } from '../../domain/model/score-board/scoreboard';
import { ScoreboardEntry, ScoreBoardService } from '../../services/score-board-service/score-board.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-score-board-list',
  templateUrl: './score-board-list.component.html',
  styleUrls: ['./score-board-list.component.scss']
})
export class ScoreBoardListComponent implements OnInit {
//  availableRounds = Array.from({ length: 38 }, (_, i) => i + 1);
//   selectedRound = 12;
//   scoreboard: ScoreboardEntry[] = [];

//   constructor(private scoreboardService: ScoreBoardService) {}

//   ngOnInit() {
//     this.loadScoreboard();
//   }

//   loadScoreboard() {
//     this.scoreboardService.getByRound(this.selectedRound).subscribe(data => {
//       this.scoreboard = data;
//     });
//   }

roundFormGroup!: FormGroup;
  availableRounds = Array.from({ length: 38 }, (_, i) => i + 1);
  scoreboard: ScoreboardEntry[] = [];

  constructor(
    private fb: FormBuilder,
    private scoreboardService: ScoreBoardService
  ) {}

  ngOnInit(): void {
    this.roundFormGroup = this.fb.group({
      roundCtrl: [this.availableRounds[0]]
    });

    this.loadScoreboard(this.roundFormGroup.value.roundCtrl);
  }

  onRoundChange(): void {
    const round = this.roundFormGroup.value.roundCtrl;
    this.loadScoreboard(round);
  }

  loadScoreboard(round: number): void {
    this.scoreboardService.getByRound(round).subscribe(data => {
      this.scoreboard = data;
    });
  }
}
