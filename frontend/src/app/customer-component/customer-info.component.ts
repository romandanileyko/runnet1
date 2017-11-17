/**
 * Created by danil on 16.11.2017.
 */
import {Component} from "@angular/core";
import {AdminService} from "../admin-component/admin.service";
@Component({
  selector:'customer-info',
  templateUrl:'./customer-info.component.html',
  providers:[AdminService]
})

export class CustomerInfoComponent{
  vUser:string;
  customerInfo:any;
  constructor(private admService:AdminService){}

  getCustomerInfoData(vUser){
    this.admService.customerInfo(vUser).subscribe(
      response => {this.customerInfo = response,
        error => console.log(error)})
  }

}
