import { Postulant } from "../postulants/postulant";
import { Recruteur } from "../recruteurs/Recruteur";
export interface Offre{
    offreId : number ; 
	titre_offre : string; 
	domaine_offre : string ; 
	region_offre : string ; 
	condition_offre : string ; 
    date_offre : Date;
	postulants_offre : Array<Postulant> ;
    recruteur : Recruteur ; 
	postulant : Postulant ;

}