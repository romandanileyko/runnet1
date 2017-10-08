import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Router} from "@angular/router";
import 'rxjs/add/operator/map';

@Injectable()
export class LoginService{
  constructor(private http:Http,private router:Router){}
  //Login function, call POST method for pass credentials(from login form)
  login(credentials){
    this.http.post('./login',credentials)
      .map(res=>{
        console.log(res.headers.get("authorization")),
          localStorage.setItem("Authorization",res.headers.get("authorization"));
        this.router.navigate(['./test']);

      }).subscribe(

      error => console.log(error)
    );
  }
  //There is returning loggedin status
  loggedIn(){
    if(localStorage.getItem('Authorization'))
    {
      return true;
    }

    else {
      return false;
    }
  }

  logout(){
    localStorage.removeItem('Authorization');
    this.router.navigate(['./']);
  }

}
