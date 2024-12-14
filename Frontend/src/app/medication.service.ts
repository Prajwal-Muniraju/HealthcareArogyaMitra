import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medication } from './medication';

@Injectable({
  providedIn: 'root'
})
export class MedicationService {

  constructor(private httpClinet:HttpClient) { }

  private baseUrl="http://localhost:8080/api/medication/"

  getMedication():Observable<Medication[]>{
    return this.httpClinet.get<Medication[]>(`${this.baseUrl}`);
  }

  createMedication(medication:Medication):Observable<Medication>{

    return this.httpClinet.post<Medication>(`${this.baseUrl}`,medication);

  }

  getMedicationById(medicationId:number):Observable<Medication>{

    return this.httpClinet.get<Medication>(`${this.baseUrl}${medicationId}`);
  }

  updateMedication(medicationId:number,medication:Medication):Observable<object>{
    return this.httpClinet.put<Medication>(`${this.baseUrl}${medicationId}`,medication);

  }

  delete(medicationId:number):Observable<object>{

    return this.httpClinet.delete<Medication>(`${this.baseUrl}${medicationId}`);
  }
}
 