import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AdminautService } from './adminaut.service';

@Injectable({
  providedIn: 'root'
})
export class AdminautguardService implements CanActivate{

  constructor(private adminautService:AdminautService,private router:Router) { }

  canActivate(){

    if(this.adminautService.isUserLoggedIn()){
      return true;
    }else{
      this.router.navigate(['adminlogin'])
      return false;
    }

  }
}
