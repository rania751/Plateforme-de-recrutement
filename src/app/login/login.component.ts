import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { User } from './User';
import { HttpErrorResponse } from "@angular/common/http";
import { LocalStorageService } from '../localStorageService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
  ]
})
export class LoginComponent implements OnInit {
  
  public user!: User;
  public values = JSON.parse(this.localS.getItem('user')  || '{}'); 
     
  public ch= this.values["privilege_user"]; 
  public x= this.values["id"];
   
  public pathV = `/${this.ch}`
 // public pathV = "./admin/recruteurs" ; 
  constructor( private authService : AuthService , private localS :  LocalStorageService) { }

  ngOnInit(): void {

  }

  public LogIn(pseudo : string , mdp : string): void {
    
   
    console.log("hetha pseudo" , pseudo) ; 
    this.authService.LogIn(pseudo , mdp).subscribe(
      
      (response: User) => {
        this.user = response;
        console.log(this.user);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

    console.log(this.user);
    this.localS.setItem('user' , JSON.stringify(this.user)) ; 
 
  } 

  
}
