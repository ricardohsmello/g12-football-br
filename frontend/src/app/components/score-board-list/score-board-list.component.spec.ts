import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScoreBoardListComponent } from './score-board-list.component';

describe('ScoreBoardListComponent', () => {
  let component: ScoreBoardListComponent;
  let fixture: ComponentFixture<ScoreBoardListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScoreBoardListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScoreBoardListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
