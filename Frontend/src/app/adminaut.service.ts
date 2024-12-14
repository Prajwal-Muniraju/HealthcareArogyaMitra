import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminautService {

  constructor() { }

  authenticate(adminUserName:string,adminPassword:string){
if(adminUserName=='prajj' && adminPassword=='prajj123'){

  sessionStorage.setItem('adminUserName2',adminUserName);
  return true;
}
else{

  return false;
}
  }

  isUserLoggedIn(){

    console.log("user is in")
    let user=sessionStorage.getItem('adminUserName2');
  
    return !(user==null)
  }

  logout(){
    console.log("logout done")
    sessionStorage.removeItem('adminUserName2');
  }
}
