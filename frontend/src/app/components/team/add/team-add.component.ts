import {Component, Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { TeamService } from '../../../services/team-service/team-service.service';

export interface DialogData {
  name: string;
}

@Component({
  selector: 'app-team-add',
  templateUrl: './team-add.component.html',
  styleUrls: ['./team-add.component.scss']
})
export class TeamAddComponent {

    constructor(
    public dialogRef: MatDialogRef<TeamAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    private teamService: TeamService
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}
