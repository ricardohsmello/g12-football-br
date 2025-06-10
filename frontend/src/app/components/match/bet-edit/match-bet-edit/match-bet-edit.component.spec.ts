import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchBetEditComponent } from './match-bet-edit.component';

describe('MatchBetEditComponent', () => {
  let component: MatchBetEditComponent;
  let fixture: ComponentFixture<MatchBetEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchBetEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MatchBetEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
