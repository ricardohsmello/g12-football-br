import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { TeamService } from '../../../services/team-service/team-service.service';
import { Team } from '../../../domain/model/team';

@Component({
  selector: 'app-match-add',
  templateUrl: './match-add.component.html',
  styleUrls: ['./match-add.component.scss']
})
export class MatchAddComponent implements OnInit {
  firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required],
  }); 
  thirdFormGroup = this._formBuilder.group({
    thirdCtrl: ['', Validators.required],
  });
  isLinear = false;

  teams: Team[];


  constructor(private _formBuilder: FormBuilder,
    private teamService: TeamService) {    
  }

  ngOnInit(): void {
    this.teamService.findAll().subscribe(data => {
      console.log(data)
      this.teams = data;
    });
  
  }


  public save() {
    console.log(this.firstFormGroup.value.firstCtrl);
  }
}


/** teams: Team[];

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
 */
