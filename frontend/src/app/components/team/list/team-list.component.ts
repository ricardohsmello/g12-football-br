import { Component, OnInit } from '@angular/core';
import { TeamService } from '../../../services/team-service/team-service.service';
import { Team } from '../../../domain/model/team';
import { KeycloakService } from 'keycloak-angular';
import { MatDialog } from '@angular/material/dialog';
import { TeamAddComponent } from '../add/team-add.component';
 

@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrls: ['./team-list.component.scss']
})
export class TeamListComponent implements OnInit {

  teams: Team[];

  constructor(
    private teamService: TeamService,
    private readonly keycloak: KeycloakService,
    public dialog: MatDialog) {
  }

  public hasAdminRole: boolean = false;
  name?: string;

  async ngOnInit() {
    this.hasAdminRole = this.keycloak.getUserRoles().includes('admin');

    this.teamService.findAll().subscribe(data => {
      console.log(data)
      this.teams = data;
    });
  }

  public add() {

    const dialogRef = this.dialog.open(TeamAddComponent, {
      data: { name: this.name },
    })

    dialogRef.afterClosed().subscribe(async result => {      
      (await this.teamService.save(result)).subscribe( result =>
        console.log('aqui')
        );      
    }    

    );
  }
}