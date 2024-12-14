import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-docdash',
  templateUrl: './docdash.component.html',
  styleUrl: './docdash.component.css'
})
export class DocdashComponent {

  constructor(private patientService:PatientService,private roter:Router){}
  patients:Patient[]=[];

  ngOnInit():void{
    this.getPatients();
  }
  
  getPatients(){
      this.patientService.getpatientList().subscribe(data=>{
        this.patients=data;
      })
  }
  update(pid:number){

    this.roter.navigate(['update-patient',pid])
  }

  delete(pid:number){
    this.patientService.delete(pid).subscribe(data=>{
      console.log(data);
      this.getPatients();
    })
  }

  view(pid:number){

    this.roter.navigate(['view-patient',pid]);
  }

}
