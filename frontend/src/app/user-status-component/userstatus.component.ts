import {Component} from "@angular/core";
import {AdminService} from "../admin-component/admin.service";
@Component({
  selector:'user-status',
  templateUrl:'./user-status.component.html',
  providers:[AdminService]
})

export class userStatus{
  vUser:string;
  userPortStatus: any;

  constructor(private admServ:AdminService){}

  getUserPortStatus(vUser){
    this.admServ.userPortStatus(vUser).subscribe(
      (response:Response) => this.userPortStatus = response,
      error=>console.log(error));
  }
}
