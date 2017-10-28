import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {LoginComponent} from "./login-component/login.component";
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {LoginService} from "./login-component/LoginService";
import {AdminComponent} from "./admin-component/admin.component";
import {AuthGuard} from "./AuthGuard";
import {UserComponent} from "./user-component/user.component";
import {AdminService} from "./admin-component/admin.service";

const appRoutes: Routes =[
  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthGuard]},
  {path:'user',component:UserComponent,canActivate:[AuthGuard]}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [LoginService,AuthGuard,AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }
