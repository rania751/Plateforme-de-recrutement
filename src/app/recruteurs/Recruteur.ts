import { Offre } from "src/app/offres/offres";



export interface Recruteur {
    id : number ; 
    nom_recruteur :String; 
	prenom_recruteur : String;
	pays_recruteur  : String;
	region_recruteur : String ; 
	fonction_recruteur : String ; 
	numerotlf_recruteur : String ; 
    offres: Array<Offre> ;
}