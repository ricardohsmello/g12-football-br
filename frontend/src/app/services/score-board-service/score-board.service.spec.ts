import { TestBed } from '@angular/core/testing';

import { ScoreBoardService } from './score-board.service';

describe('ScoreBoardService', () => {
  let service: ScoreBoardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScoreBoardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
