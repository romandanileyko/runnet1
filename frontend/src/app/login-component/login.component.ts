import {Component} from "@angular/core";
import {LoginService} from "./LoginService";

@Component({
  selector: 'login',
  templateUrl:'./login.component.html',
  styleUrls:['./login.component.css']
})

export class LoginComponent{

  constructor(private auth:LoginService){}

  onLogin(credentials) {
    console.log(credentials);
    this.auth.login(credentials);
  }
  logout(){
    this.auth.logout();
  }
}
