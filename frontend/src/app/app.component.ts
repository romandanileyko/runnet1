import { Component } from '@angular/core';
import {LoginService} from "./login-component/LoginService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private auth:LoginService){}

  logout(){
    this.auth.logout();
  }
}
