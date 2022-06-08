
import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { HttpErrorResponse } from "@angular/common/http";
import { Postulant } from "./postulant";
import { PostulantService } from "./postulants.service";





@Component({
  selector: 'app-postulants',
  templateUrl: './postulants.component.html',
  
})


export class PostulantsComponent implements OnInit {
  

  //Partie postulant
  public postulants: Postulant[] | undefined;
  public editPostulant: Postulant | undefined;
  public deletePostulant: Postulant | undefined;

  constructor(  private postulantService: PostulantService) {}
  ngOnInit() {
    this.getPostulants();
   
  }

  public getPostulants(): void {
    
    this.postulantService.getPostulants().subscribe(
      (response: Postulant[]) => {
        this.postulants = response;
        console.log(this.postulants);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 

  public onAddPostulant(addForm: NgForm): void {
    document.getElementById("add-postulant-form")?.click() ; 

    this.postulantService.addPostulant(addForm.value).subscribe(
      (response: Postulant) => {
        console.log(response);
        this.getPostulants();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdatePostulant(postulant: Postulant): void {
    console.log("hetha wost el edit");
    console.log(postulant);
    this.postulantService.updatePostulant(postulant).subscribe(
      (response: Postulant) => {
        console.log("beg rep");
        console.log(response);
        console.log("end rep");
        this.getPostulants();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 

  public onDeletePostulant(postulantId: number | undefined ): void {
    if (postulantId != null){
    this.postulantService.deletePostulant(postulantId)?.subscribe(
      (response: void) => {
        console.log(response);
        this.getPostulants();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
   } }

  public searchPostulants(key: string): void {
    console.log(key);
    const results: Postulant[] = [];
    if (typeof this.postulants != "undefined") {
    for (const postulant of this.postulants) {
      if (postulant.nom_postulant.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || postulant.prenom_postulant.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || postulant.pays_postulant.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || postulant.region_postulant.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || postulant.fonction_postulant.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(postulant);
      }
    }}
    this.postulants = results;
    if (results.length === 0 || !key) {
      this.getPostulants();
    }
  } 

  public onOpenModalR(postulant: any, mode: string): void {
    const container = document.getElementById("main-container");
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addPostulantModal');
    } 
    if (mode === 'edit') {
      this.editPostulant = postulant;
      button.setAttribute('data-target', '#updatePostulantModal');
    }
    if (mode === 'delete') {
      this.deletePostulant = postulant;
      button.setAttribute('data-target', '#deletePostulantModal');
    } 
    if  (container !== null) {
      container.appendChild(button);
  }
  
    button.click();
  }

}


