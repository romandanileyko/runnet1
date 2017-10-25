import {Component, OnInit} from "@angular/core";
@Component({
  selector:'user',
  templateUrl:'./user.component.html'
})
export class UserComponent implements OnInit{
  testText: string;

  constructor(){}

  ngOnInit(){
    this.testText = 'Hello World,user!';
  }
}
