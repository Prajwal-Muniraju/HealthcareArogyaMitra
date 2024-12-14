import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DocautService {

  constructor() { }

  authenticate(doctorUsername:string,doctorPassword:string){

    if(doctorUsername=="praj" && doctorPassword=="praj123"){

      sessionStorage.setItem('doctorUsername',doctorUsername);
      return true;
    }else{
      return false;
    }
  }
}
