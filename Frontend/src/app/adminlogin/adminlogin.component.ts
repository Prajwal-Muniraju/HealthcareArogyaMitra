import { Component } from '@angular/core';
import { AdminautService } from '../adminaut.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrl: './adminlogin.component.css'
})
export class AdminloginComponent {

  adminUserName:string=''
  adminPassword:string=''
  inValidLogin=false;

  constructor(private adminautService:AdminautService,private router:Router){}

  checkLogin(){
    if(this.adminautService.authenticate(this.adminUserName,this.adminPassword)){

      this.router.navigate(['admin'])
      this.inValidLogin=false;

    }else{

      this.inValidLogin=true;
      alert("wrong credentials");
      this.router.navigate(['home'])
    }
  }
  
}
