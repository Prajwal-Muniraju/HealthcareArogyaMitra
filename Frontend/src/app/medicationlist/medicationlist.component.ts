import { Component } from '@angular/core';
import { MedicationService } from '../medication.service';
import { Medication } from '../medication';
import { Router } from '@angular/router';

@Component({
  selector: 'app-medicationlist',
  templateUrl: './medicationlist.component.html',
  styleUrl: './medicationlist.component.css'
})
export class MedicationlistComponent {

  medications:Medication[]=[];
  constructor(private medicationService:MedicationService,private roter:Router){

  }

  ngOnInit():void{
    this.getMedication();
  }

  getMedication(){

    this.medicationService.getMedication().subscribe(data=>{
      this.medications=data;

    })
  }

  update(medicationId:number){

    this.roter.navigate(['update-medication',medicationId])

  }

  delete(medicationId:number)
  {
    this.medicationService.delete(medicationId).subscribe(data=>{
      console.log(data);
      this.getMedication();
    })
  }
  }



