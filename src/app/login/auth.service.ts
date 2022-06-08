import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    private apiServerUrl=environment.apiBaseUrl ; 
  
      constructor (private http : HttpClient) {} 
  
      public LogIn(pseudo : string , mdp : string ) : Observable<any> {
        let param = new HttpParams() ; 
        param=param.append("pseudoUser", pseudo);
        param = param.append("motdepasseUser" , mdp) ; 

        return this.http.get<any> (`${this.apiServerUrl}/login`, {params : param}) ; 
    }

 

    

}