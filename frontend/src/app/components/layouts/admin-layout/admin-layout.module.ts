import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../dashboard/dashboard.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { ChartsModule } from 'ng2-charts';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
import { ScoreBoardListComponent } from '../../score-board-list/score-board-list.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { MatDialog, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatchAddComponent } from '../../match/add/match-add.component';
import { MaterialExampleModule } from '../../../../material.module';
import { MatchListComponent } from '../../match/list/match-list/match-list.component';
import { MatchScoreEditComponent } from '../../match/score-edit/match-score-edit/match-score-edit.component';
import { MatchBetEditComponent } from '../../match/bet-edit/match-bet-edit/match-bet-edit.component';
import { ConfirmDialogComponent } from '../../dialog/confirm-dialog.component'

@NgModule({
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    ChartsModule,
    NgbModule,
    MatFormFieldModule,
    MatButtonModule,
    MatDialogModule,
    ReactiveFormsModule,
    MaterialExampleModule,
    ToastrModule.forRoot()
  ],
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    NotificationsComponent,
    ScoreBoardListComponent,
    MatchAddComponent,
    MatchListComponent,
    MatchScoreEditComponent,
    MatchBetEditComponent,
    ConfirmDialogComponent
    
  ],
  entryComponents: [],
  providers: [MatDialog]

})

export class AdminLayoutModule {}
