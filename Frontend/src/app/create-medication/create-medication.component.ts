import { Component } from '@angular/core';
import { Medication } from '../medication';
import { MedicationService } from '../medication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-medication',
  templateUrl: './create-medication.component.html',
  styleUrl: './create-medication.component.css'
})
export class CreateMedicationComponent {

  medication:Medication=new Medication();

  constructor(private medicationService:MedicationService,private roter:Router){}

  saveMedication(){
    this.medicationService.createMedication(this.medication).subscribe(data=>{
      console.log(data);
      this.goToViewMedication();

    })

  }

  onSubmit(){
    this.saveMedication();

  }

  goToViewMedication(){
    this.roter.navigate([`/view-medication`])

  }
}

