
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

    public getOffresR(recruteurId : number) : Observable<Offre[]> {
        return this.http.get<Offre[]> (`${this.apiServerUrl}/recruteur/${recruteurId}/all`) ; 
    }

    public getOffreById(offreId :number ) : Observable<Offre> {
        return this.http.get<Offre> (`${this.apiServerUrl}/find/${offreId}`) ; 
    }

    public getOffreByIdR(offreId :number , recruteurId : number) : Observable<Offre> {
        return this.http.get<Offre> (`http://localhost:8080/recruteur/${recruteurId}/find/${offreId}`) ; 
    }

    public addOffre(offre : Offre) : Observable<Offre> {
        return this.http.post<Offre> (`${this.apiServerUrl}/add` , offre) ; 
    }

    public addOffreR(recruteurId : number , offre : Offre) : Observable<Offre> {
        return this.http.post<Offre> (`http://localhost:8080/recruteur/${recruteurId}/add` , offre) ; 
    }

    public updateOffre(offre : Offre) : Observable<Offre> {
        return this.http.put<Offre> (`${this.apiServerUrl}/update` , offre) ; 
    }

    public updateOffreR(offre : Offre ,recruteurId : number ) : Observable<Offre> {
        return this.http.put<Offre> (`http://localhost:8080/recruteur/${recruteurId}/update` , offre) ; 
    }
    public deleteOffre(offreId :number ) : Observable<void> {
        return this.http.delete<void> (`${this.apiServerUrl}/delete/${offreId}`) ; 
    }

    public deleteOffreR(offreId :number , recruteurId : number ) : Observable<void> {
        return this.http.delete<void> (`http://localhost:8080/recruteur/${recruteurId}/delete/${offreId}`) ; 
    }

}