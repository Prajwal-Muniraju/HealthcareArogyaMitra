import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpClient:HttpClient) { }

  private baseUrl="http://localhost:8080/api/patient/"

    getpatientList():Observable<Patient[]>
    {
        return this.httpClient.get<Patient[]>(`${this.baseUrl}`)
    }
    delete(pid:number):Observable<object>{
      return this.httpClient.delete(`${this.baseUrl}${pid}`);
    }

    createPatient(patient:Patient):Observable<Patient>{

      return this.httpClient.post<Patient>(`${this.baseUrl}`,patient);
    }

    getPatientById(pid:number):Observable<Patient>{

      return this.httpClient.get<Patient>(`${this.baseUrl}${pid}`);
    }

    updatePatient(pid:number,patient:Patient):Observable<object>{

      return this.httpClient.put<Patient>(`${this.baseUrl}${pid}`,patient);
    }
}

