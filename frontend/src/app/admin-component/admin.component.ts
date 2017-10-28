import {Component, OnInit} from "@angular/core";
import {AdminService} from "./admin.service";
import {Response} from "@angular/http";

@Component({
  selector:'admin',
  templateUrl:'./admin.component.html',
  providers:[AdminService]
})

export class AdminComponent implements OnInit{
  testText:string;
  portstatus: any;
  currentPortStatus : any;

  constructor(private admServ:AdminService){}

  ngOnInit(){
    this.testText="Hello World!";
    this.admServ.getNotUpStatusPort().subscribe(response =>{this.portstatus = response}),
       error=>console.log(error),
      ()=>console.log(this.portstatus)
  }

  unBlockPort(item){
    console.log("Device Ip: "+ item.devIp + " Interface Name: "+item.ifName);
    this.admServ.setNoShut(item.devIp,item.ifName).subscribe(
      (response:Response)=>{console.log(response),this.portStatus(item)},
      error=>console.log(error));
  }

  portStatus(item){
    this.admServ.portStatus(item.devIp,item.ifName).subscribe((response:Response)=>{
      this.currentPortStatus = response.text();
      alert("Current Port Status: "+ this.currentPortStatus);
    },
    error2 => console.log(error2))
  }
}
