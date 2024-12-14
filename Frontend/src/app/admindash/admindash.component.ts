import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { AdminautService } from '../adminaut.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admindash',
  templateUrl: './admindash.component.html',
  styleUrl: './admindash.component.css'
})
export class AdmindashComponent {
  patients:Patient[]=[];
  constructor(private patientService:PatientService,private adminautService:AdminautService,private router:Router){}
  
  ngOnInit():void
  {
    this.getPatients();
  }

getPatients(){
  this.patientService.getpatientList().subscribe(data=>{
  this.patients=data;
  })
}
delete(pid:number){
  this.patientService.delete(pid).subscribe(data=>{
    console.log(data);
    this.getPatients();
  })
}
logout(){

  this.adminautService.logout();
  this.router.navigate(['home'])
}

}
