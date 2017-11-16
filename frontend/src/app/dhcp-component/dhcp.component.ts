import {Component} from "@angular/core";
import {AdminService} from "../admin-component/admin.service";
@Component({
  selector:'dhcp',
  templateUrl:'./dhcp.component.html',
  providers:[AdminService]
})

export class DhcpComponent{
  vUser:string;
  dhcpLogData:any;
  constructor(private admServ:AdminService){}

  getDhcpLogData(vUser){
    this.admServ.dhcpLog(vUser).subscribe(
      response => {this.dhcpLogData = response,
      error => console.log(error)})
  }
}
