import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchScoreEditComponent } from './match-score-edit.component';

describe('MatchScoreEditComponent', () => {
  let component: MatchScoreEditComponent;
  let fixture: ComponentFixture<MatchScoreEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchScoreEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MatchScoreEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
