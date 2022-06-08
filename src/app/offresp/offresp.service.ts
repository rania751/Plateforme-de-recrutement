
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http' ; 
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Offre } from "src/app/offres/offres";



@Injectable({
  providedIn: 'root'
})
export class OffreService {

  private apiServerUrl=environment.apiBaseUrl ; 

    constructor (private http : HttpClient) {} 

    public getOffres() : Observable<Offre[]> {
        return this.http.get<Offre[]> ("http://localhost:8080/all") ; 
    } 
}