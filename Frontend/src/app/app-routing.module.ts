import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashComponent } from './admindash/admindash.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { HomeComponent } from './home/home.component';
import { DocdashComponent } from './docdash/docdash.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { MedicationlistComponent } from './medicationlist/medicationlist.component';
import { CreateMedicationComponent } from './create-medication/create-medication.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';
import { UpdateMedicationComponent } from './update-medication/update-medication.component';
import { DocloginComponent } from './doclogin/doclogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminautguardService } from './adminautguard.service';

const routes: Routes = [
  {path:'admin',component:AdmindashComponent,canActivate:[AdminautguardService]},
  {path:'appointmentlist',component:AppointmentComponent,canActivate:[AdminautguardService]},
  {path:'create-appointment',component:CreateAppointmentComponent},
  {path:'home',component:HomeComponent},
  {path:'docdash',component:DocdashComponent},
  {path:'create-patient',component:CreatePatientComponent},
  {path:'view-medication',component:MedicationlistComponent},
  {path:'create-medication',component:CreateMedicationComponent},
  {path:'update-patient/:pid',component:UpdatePatientComponent},
  {path:'view-patient/:pid',component:ViewPatientComponent},
  {path:'update-medication/:medicationId',component:UpdateMedicationComponent},
  {path:'doclogin',component:DocloginComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'',redirectTo:'home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
