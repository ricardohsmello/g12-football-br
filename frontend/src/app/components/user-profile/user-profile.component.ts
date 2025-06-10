import { Component, OnInit } from '@angular/core';
import { KeycloakProfile } from 'keycloak-js';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  public isLogged = false;
  public profile: KeycloakProfile | null = null;

  constructor(private readonly keycloak: KeycloakService) {}

  async ngOnInit() {
    this.isLogged = await this.keycloak.isLoggedIn();

    if (this.isLogged) {
      this.profile = await this.keycloak.loadUserProfile(); 
     }  
 
  }
}
