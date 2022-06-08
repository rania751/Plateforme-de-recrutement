
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http' ; 
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Postulant } from './postulant';



@Injectable({
  providedIn: 'root'
})
export class PostulantService {

  private apiServerUrl=environment.apiBaseUrl ; 

    constructor (private http : HttpClient) {} 

    public getPostulants() : Observable<Postulant[]> {
        return this.http.get<Postulant[]> ("http://localhost:8080/postulant/all") ; 
    }

    public getPostulantById(postulantId :number ) : Observable<Postulant> {
        return this.http.get<Postulant> (`${this.apiServerUrl}/postulant/find/${postulantId}`) ; 
    }

    public addPostulant(postulant : Postulant) : Observable<Postulant> {
        return this.http.post<Postulant> (`${this.apiServerUrl}/postulant/add` , postulant) ; 
    }

    public updatePostulant(postulant : Postulant) : Observable<Postulant> {
        return this.http.put<Postulant> (`${this.apiServerUrl}/postulant/update` , postulant) ; 
    }
    public deletePostulant(postulantId :number ) : Observable<void> {
        return this.http.delete<void> (`${this.apiServerUrl}/postulant/delete/${postulantId}`) ; 
    }

}