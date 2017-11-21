import { Component } from '@angular/core';
import {LoginService} from "./login-component/LoginService";
import {NavigationEnd, NavigationStart, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  initRouter: string;
  isExpToken: boolean;

  constructor(private auth:LoginService){
  }
  logout(){
    this.auth.logout();
  }
}
