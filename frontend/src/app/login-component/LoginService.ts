import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Router} from "@angular/router";
import 'rxjs/add/operator/map';
import {Observable} from "rxjs";

@Injectable()
export class LoginService{
  isAdminRole: boolean;
  errorCode:any;
  constructor(private http:Http,private router:Router){}
  //Login function, call POST method for pass credentials(from login form)
  login(credentials){
    this.http.post('./login',credentials)
      .map(res=>{
        console.log(res);
        console.log(res.headers.get("authorization")),
          localStorage.setItem("Authorization",res.headers.get("authorization"));
          if(this.jwtData(res.headers.get("authorization"))=='ROLE_ADMIN') {
            this.isAdminRole = true;
            this.router.navigate(['./admin']);
          } else if (this.jwtData(res.headers.get("authorization"))=='ROLE_USER'){
            this.isAdminRole = false;
            this.router.navigate(['./user']);
          }
      }).catch((error:any) =>{
      if(error.status == 401){this.errorCode = 401}
      return Observable.throw(error);
    }).subscribe((error:any) => {console.log("Error: "+error);}
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
   //  console.log('decodedJwtJsonData: ' + decodedJwtJsonData);
   // console.log('decodedJwtData: ' + decodedJwtData);
   //  console.log('role: ' + userRole);
   //  console.log('date: ' + new Date());
   //  console.log('date1: ' + new Date(decodedJwtData.exp));
    return userRole;
  }

  jwtIsExpire(jwtToken){
    let token = jwtToken;

    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = window.atob(jwtData);
    let decodedJwtData = JSON.parse(decodedJwtJsonData);

    var expireDate = decodedJwtData.exp;
    var currentDate = Date.now()*0.001;
    console.log("EXP:"+expireDate);
    console.log("CUR:"+currentDate);
    let logOutFlag = false;
    if(currentDate > expireDate){
      logOutFlag = true;
    }
    return logOutFlag;
  }

  isAdmin(){
    if(this.isAdminRole){return true;}
    else {return false;}
  }
  isLoginFailed(){
    if(this.errorCode == 401){return true;}
    else {return false;}
  }
}
