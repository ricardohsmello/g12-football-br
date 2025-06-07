import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/dashboard', title: 'Dashboard',  icon: 'design_app', class: '' },
    { path: '/teams', title: 'Teams',  icon:'objects_support-17', class: '' },
    { path: '/match', title: 'Matches',  icon:'objects_spaceship', class: '' },
    { path: '/notifications', title: 'Notifications',  icon:'ui-1_bell-53', class: '' },
    { path: '/scoreboard', title: 'Score Board',  icon:'sport_trophy', class: '' }
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ( window.innerWidth > 991) {
          return false;
      }
      return true;
  };
}
