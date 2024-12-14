import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DocautService } from '../docaut.service';

@Component({
  selector: 'app-doclogin',
  templateUrl: './doclogin.component.html',
  styleUrl: './doclogin.component.css'
})
export class DocloginComponent {

  doctorUsername:string="";
  doctorPassword:string="";

  invalidLogin=false;

constructor(private router:Router,private docaut:DocautService){}

  checkLogin(){

    if(this.docaut.authenticate(this.doctorUsername,this.doctorPassword)){

      alert("Login Successful")

      this.router.navigate(['docdash'])
      this.invalidLogin=false;
   
    }
    else{
      alert("wrong Credintails")
      this.invalidLogin=true;
      this.router.navigate(['home']) 
    }
  }
}
