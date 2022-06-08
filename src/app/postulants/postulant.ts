import { Offre } from "src/app/offres/offres";

export interface Postulant{
    id : number ; 
    nom_postulant : string ; 
    prenom_postulant : string ; 
    pays_postulant : string ; 
    region_postulant : string ; 
    fonction_postulant : string ; 
    numerotlf_postulant : String; 
    cv_postulant : String ;
    offres_postulant : Array<Offre> ;
}

