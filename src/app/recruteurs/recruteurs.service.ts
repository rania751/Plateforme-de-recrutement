
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http' ; 
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Recruteur } from '../recruteurs/Recruteur';


@Injectable({
  providedIn: 'root'
})
export class RecruteurService {

  private apiServerUrl=environment.apiBaseUrl ; 

    constructor (private http : HttpClient) {} 

    public getRecruteurs() : Observable<Recruteur[]> {
        return this.http.get<Recruteur[]> (`${this.apiServerUrl}/recruteur/all`) ; 
    }

    public getRecruteurById(recruteurId :number ) : Observable<Recruteur> {
        return this.http.get<Recruteur> (`${this.apiServerUrl}/recruteur/find/${recruteurId}`) ; 
    }

    public addRecruteur(recruteur : Recruteur) : Observable<Recruteur> {
        return this.http.post<Recruteur> (`${this.apiServerUrl}/recruteur/add` , recruteur) ; 
    }

    public updateRecruteur(recruteur : Recruteur) : Observable<Recruteur> {
        return this.http.put<Recruteur> (`${this.apiServerUrl}/recruteur/update` , recruteur) ; 
    }
    public deleteRecruteur(recruteurId :number ) : Observable<void> {
        return this.http.delete<void> (`${this.apiServerUrl}/recruteur/delete/${recruteurId}`) ; 
    }
    

    

}