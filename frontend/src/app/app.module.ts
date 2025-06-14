import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { AppComponent } from './app.component';
import { AdminLayoutComponent } from './components/layouts/admin-layout/admin-layout.component';
import {MaterialExampleModule} from '../material.module';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';

export function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
  keycloak.init({
    config: {
    url: 'https://g12-football-br-1.onrender.com',
    realm: 'g12',
    clientId: 'frontend'
    },
  initOptions: {
  onLoad: 'login-required',
  // onLoad: 'check-sso',
  //  checkLoginIframe: false,
  silentCheckSsoRedirectUri:
    window.location.origin + '/assets/silent-check-sso.html'
  }
  });
}

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule,
    RouterModule,
    AppRoutingModule,
    NgbModule,
    KeycloakAngularModule,
    MaterialExampleModule,
    ToastrModule.forRoot(),
    MatSnackBarModule,
    MatFormFieldModule,
    MatIconModule
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent    
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    }    
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
