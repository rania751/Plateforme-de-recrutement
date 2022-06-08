import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { HttpErrorResponse } from "@angular/common/http";
import { Offre } from "src/app/offres/offres";
import { OffreService } from "./offresp.service";


@Component({
  selector: 'app-offresp',
  templateUrl: './offresp.component.html',
  styleUrls: ['./offresp.component.css']
})
export class OffrespComponent implements OnInit {
  

  //Partie offre
  public offres: Offre[] | undefined;
  public editOffre: Offre | undefined;
  public deleteOffre: Offre | undefined;
  
  

  constructor(  private offreService: OffreService) {}
  ngOnInit() {
    
     this.getOffres();
   
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

  
}






