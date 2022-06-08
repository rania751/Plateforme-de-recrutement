
import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { HttpErrorResponse } from "@angular/common/http";
import { Offre } from "src/app/offres/offres";
import { OffreService } from "./offres.service";
import { LocalStorageService } from "../localStorageService";





@Component({
  selector: 'app-offres',
  templateUrl: './offres.component.html',
  
})


export class OffresComponent implements OnInit {

  constructor(  private offreService: OffreService , private localS : LocalStorageService) {}
  //Partie offre
  public offres: Offre[] | undefined;
  public editOffre: Offre | undefined;
  public deleteOffre: Offre | undefined;
  
  
  public values = JSON.parse(this.localS.getItem('user')  || '{}'); 
  x = this.values["id"];
  
  ngOnInit(): void {
      this.getOffresR(7) ; 
  }

  public getOffres(): void {
    
    this.offreService.getOffres().subscribe(
      (response: Offre[]) => {
        this.offres = response;
        console.log(this.offres);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 
  public getOffresR(x :number ): void {
    
    this.offreService.getOffresR(x).subscribe(
      (response: Offre[]) => {
        this.offres = response;
        console.log(this.offres);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 

  /*public onAddOffre(addForm: NgForm): void {
    document.getElementById("add-offre-form")?.click() ; 

    this.offreService.addOffre(addForm.value).subscribe(
      (response: Offre) => {
        console.log(response);
        this.getOffres();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }*/

  public onAddOffreR(addForm: NgForm , x : number): void {
    document.getElementById("add-offre-form")?.click() ; 

    this.offreService.addOffreR(x , addForm.value ).subscribe(
      (response: Offre) => {
        console.log(response);
        this.getOffresR(x);
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateOffre(offre: Offre): void {
    
    console.log(offre);
    this.offreService.updateOffre(offre).subscribe(
      (response: Offre) => {
        console.log(response);
        this.getOffres();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 

  public onUpdateOffreR(offre: Offre , x: number): void {
    
    console.log(offre);
    this.offreService.updateOffreR(offre , x).subscribe(
      (response: Offre) => {
        console.log(response);
        this.getOffres();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 

  public onDeleteOffre(offreId: number | undefined ): void {
    if (offreId != null){
    this.offreService.deleteOffre(offreId)?.subscribe(
      (response: void) => {
        console.log(response);
        this.getOffres();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
   } }


   public onDeleteOffreR(offreId: number | undefined , x : number): void {
    if (offreId != null){
    this.offreService.deleteOffreR(offreId , x)?.subscribe(
      (response: void) => {
        console.log(response);
        this.getOffresR(x);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
   } }

  public searchOffres(key: string): void {
    console.log(key);
    const results: Offre[] = [];
    if (typeof this.offres != "undefined") {
    for (const offre of this.offres) {
      if (offre.titre_offre.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || offre.domaine_offre.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || offre.region_offre.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || offre.condition_offre.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(offre);
      }
    }}
    this.offres = results;
    if (results.length === 0 || !key) {
      this.getOffres();
    }
  } 

  public onOpenModalR(offre: any, mode: string): void {
    const container = document.getElementById("main-container");
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addOffreModal');
    } 
    if (mode === 'edit') {
      this.editOffre = offre;
      button.setAttribute('data-target', '#updateOffreModal');
    }
    if (mode === 'delete') {
      this.deleteOffre = offre;
      button.setAttribute('data-target', '#deleteOffreModal');
    } 
    if  (container !== null) {
      container.appendChild(button);
  }
  
    button.click();
  }


  public onOpenModalRec(offre: any, mode: string): void {
    const container = document.getElementById("main-container");
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addOffreModal');
    } 
    if (mode === 'edit') {
      this.editOffre = offre;
      button.setAttribute('data-target', '#updateOffreModal');
    }
    if (mode === 'delete') {
      this.deleteOffre = offre;
      button.setAttribute('data-target', '#deleteOffreModal');
    } 
    if  (container !== null) {
      container.appendChild(button);
  }
  
    button.click();
  }

}


