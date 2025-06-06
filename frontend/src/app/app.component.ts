import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {
  constructor() {}

 
 public async ngOnInit() {
 }

  // title = 'Football news'
  // roles?: string[];

  // public isLogueado = false;
  // public perfilUsuario: KeycloakProfile | null = null;

  // constructor(private readonly keycloak: KeycloakService) {}

  // public async ngOnInit() {
 
  //   this.roles = this.keycloak.getUserRoles();

  //   this.isLogueado = await this.keycloak.isLoggedIn();

  //   if (this.isLogueado) {
  //     this.perfilUsuario = await this.keycloak.loadUserProfile();
  //   }
  // }

  // public isAdmin() {
  //   return this.roles?.includes('football-news-producer')
  // }
  // public iniciarSesion() {
  //   this.keycloak.login();
  // }

  // public cerrarSesion() {
  //   this.keycloak.logout();
  // }
}
