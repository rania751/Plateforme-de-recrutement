
import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { HttpErrorResponse } from "@angular/common/http";

import { RecruteurService } from "./recruteurs.service";
import { Recruteur } from "./Recruteur";





@Component({
  selector: 'app-recruteurs',
  templateUrl: './recruteurs.component.html',
  
})


export class RecruteursComponent implements OnInit {
  

  //Partie recruteur
  public recruteurs: Recruteur[] | undefined;
  public editRecruteur: Recruteur | undefined;
  public deleteRecruteur: Recruteur | undefined;

  constructor(  private recruteurService: RecruteurService) {}
  ngOnInit() {
    this.getRecruteurs();
   
  }

  public getRecruteurs(): void {
    
    this.recruteurService.getRecruteurs().subscribe(
      (response: Recruteur[]) => {
        this.recruteurs = response;
        console.log(this.recruteurs);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 

  public onAddRecruteur(addForm: NgForm): void {
    document.getElementById("add-recruteur-form")?.click() ; 

    this.recruteurService.addRecruteur(addForm.value).subscribe(
      (response: Recruteur) => {
        console.log(response);
        this.getRecruteurs();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateRecruteur(recruteur: Recruteur): void {
    console.log("hetha wost el edit");
    console.log(recruteur);
    this.recruteurService.updateRecruteur(recruteur).subscribe(
      (response: Recruteur) => {
        console.log("beg rep");
        console.log(response);
        console.log("end rep");
        this.getRecruteurs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 

  public onDeleteRecruteur(recruteurId: number | undefined ): void {
    if (recruteurId != null){
    this.recruteurService.deleteRecruteur(recruteurId)?.subscribe(
      (response: void) => {
        console.log(response);
        this.getRecruteurs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
   } }

  public searchRecruteurs(key: string): void {
    console.log(key);
    const results: Recruteur[] = [];
    if (typeof this.recruteurs != "undefined") {
    for (const recruteur of this.recruteurs) {
      if (recruteur.nom_recruteur.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || recruteur.prenom_recruteur.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || recruteur.pays_recruteur.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || recruteur.region_recruteur.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || recruteur.fonction_recruteur.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(recruteur);
      }
    }}
    this.recruteurs = results;
    if (results.length === 0 || !key) {
      this.getRecruteurs();
    }
  } 

  public onOpenModalR(recruteur: any, mode: string): void {
    const container = document.getElementById("main-container");
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addRecruteurModal');
    } 
    if (mode === 'edit') {
      this.editRecruteur = recruteur;
      button.setAttribute('data-target', '#updateRecruteurModal');
    }
    if (mode === 'delete') {
      this.deleteRecruteur = recruteur;
      button.setAttribute('data-target', '#deleteRecruteurModal');
    } 
    if  (container !== null) {
      container.appendChild(button);
  }
  
    button.click();
  }

}


