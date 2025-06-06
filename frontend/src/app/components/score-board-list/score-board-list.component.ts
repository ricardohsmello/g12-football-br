
import { Component, OnInit } from '@angular/core';
import { Scoreboard } from '../../domain/model/score-board/scoreboard';
import { ScoreBoardService } from '../../services/score-board-service/score-board.service';
 
 
@Component({
  selector: 'app-score-board-list',
  templateUrl: './score-board-list.component.html',
  styleUrls: ['./score-board-list.component.scss']
})
export class ScoreBoardListComponent implements OnInit {

  scores: Scoreboard[];

  constructor(private scoreBoardService: ScoreBoardService) {
  }

  async ngOnInit() {
    this.scoreBoardService.findAll().subscribe(data => {
      console.log(data)
      this.scores = data;
    });
  }
}