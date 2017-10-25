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
          if(this.jwtData(res.headers.get("authorization"))=='ROLE_ADMIN') {
            this.router.navigate(['./admin']);
          } else if (this.jwtData(res.headers.get("authorization"))=='ROLE_USER'){
            this.router.navigate(['./user']);
          }
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

  jwtData(jwtToken){
    let token = jwtToken;

    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    let decodedJwtData = JSON.parse(decodedJwtJsonData);

    let userRole = decodedJwtData.roles[0].authority;

    // console.log('jwtData: ' + jwtData);
    // console.log('decodedJwtJsonData: ' + decodedJwtJsonData);
    // console.log('decodedJwtData: ' + decodedJwtData);
    console.log('role: ' + userRole);
    return userRole;
  }
}
