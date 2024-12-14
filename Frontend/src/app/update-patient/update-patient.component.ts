import { Component } from '@angular/core';
import { Patient } from '../patient';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrl: './update-patient.component.css'
})
export class UpdatePatientComponent {

  pid:number=0;
  constructor(private route:ActivatedRoute,private patientService:PatientService,private roter:Router){}
  patient:Patient=new Patient();

  ngOnInit():void{

    this.pid=this.route.snapshot.params['pid'];
    this.patientService.getPatientById(this.pid).subscribe(data=>{

      this.patient=data;
    })
  }

  onSubmit(){

    this.patientService.updatePatient(this.pid,this.patient).subscribe(data=>{
       
      console.log(data);
      this.goToDocDash();
    })
  }
  
  goToDocDash(){

    this.roter.navigate(['docdash'])
  }
}
