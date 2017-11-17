import {Injectable} from "@angular/core";
import {CanActivate, Router} from "@angular/router";
import {LoginService} from "./login-component/LoginService";

@Injectable()
export class AuthGuard implements CanActivate{

  constructor(private auth:LoginService,private router:Router){}

  canActivate(){
    let token = localStorage.getItem("Authorization");
    if(this.auth.jwtIsExpire(token)){
      this.auth.logout();
      this.router.navigateByUrl('/login');
      return false;
    } else if(this.auth.loggedIn()){
      return true;
    }
    else {
      this.router.navigateByUrl('/login');
      return false;
    }
  }
}
