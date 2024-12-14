import { Component } from '@angular/core';
import { Medication } from '../medication';
import { ActivatedRoute, Router } from '@angular/router';
import { MedicationService } from '../medication.service';

@Component({
  selector: 'app-update-medication',
  templateUrl: './update-medication.component.html',
  styleUrl: './update-medication.component.css'
})
export class UpdateMedicationComponent {

  medication:Medication=new Medication();

  medicationId:number=0

  constructor(private route:ActivatedRoute,private medicationService:MedicationService,private roter:Router){
    
  }

  ngOnInit():void{
    this.medicationId=this.route.snapshot.params['medicationId'];
    this.medicationService.getMedicationById(this.medicationId).subscribe(data=>{

      this.medication=data;
    })
  }
  onSubmit(){

    this.medicationService.updateMedication(this.medicationId,this.medication).subscribe(data=>{

      console.log(data);
      this.goToMedicationList();
    })
  }

  goToMedicationList(){

    this.roter.navigate(['view-medication'])
  }
}
