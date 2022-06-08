package tn.enicarthage.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER_POSTULANT")
public class Postulant extends Utilisateur {
	private String nom_postulant ; 
	private String prenom_postulant ;
	private String pays_postulant;
	private String region_postulant ; 
	private String fonction_postulant ; 
	private String numerotlf_postulant ; 
	private String cv_postulant ; 
	@ManyToMany
	@JoinTable(
			name="offresPostulés" , 
			joinColumns=@JoinColumn(name="id_user") , 
			inverseJoinColumns=@JoinColumn (name="id_offre")
			
			)
	private List <Offre> offres_postulant =new ArrayList <>() ; 
	
	public void upload_cv() {
	
	  }
	public void postuler_offre(Offre offre) {
		
	  }
	//constructeurs
	public Postulant(Long id,   String privilege_user,String pseudoUser, String motdepasse_user,
			String nom_postulant, String prenom_postulant, String pays_postulant, String region_postulant,
			String fonction_postulant, String numerotlf_postulant , String cv_postulant) {
		super(id,privilege_user, pseudoUser, motdepasse_user);
		this.nom_postulant = nom_postulant;
		this.prenom_postulant = prenom_postulant;
		this.pays_postulant = pays_postulant;
		this.region_postulant = region_postulant;
		this.fonction_postulant = fonction_postulant;
		this.numerotlf_postulant = numerotlf_postulant;
		this.cv_postulant=cv_postulant;
	}
	public Postulant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Postulant(Long id, String privilege_user, String pseudoUser, String motdepasse_user) {
		super(id, privilege_user ,  pseudoUser, motdepasse_user);
		// TODO Auto-generated constructor stub
	}
	public String getNom_postulant() {
		return nom_postulant;
	}
	public void setNom_postulant(String nom_postulant) {
		this.nom_postulant = nom_postulant;
	}
	public String getPrenom_postulant() {
		return prenom_postulant;
	}
	public void setPrenom_postulant(String prenom_postulant) {
		this.prenom_postulant = prenom_postulant;
	}
	public String getPays_postulant() {
		return pays_postulant;
	}
	public void setPays_postulant(String pays_postulant) {
		this.pays_postulant = pays_postulant;
	}
	public String getRegion_postulant() {
		return region_postulant;
	}
	public void setRegion_postulant(String region_postulant) {
		this.region_postulant = region_postulant;
	}
	public String getFonction_postulant() {
		return fonction_postulant;
	}
	public void setFonction_postulant(String fonction_postulant) {
		this.fonction_postulant = fonction_postulant;
	}
	public String getNumerotlf_postulant() {
		return numerotlf_postulant;
	}
	public void setNumerotlf_postulant(String numerotlf_postulant) {
		this.numerotlf_postulant = numerotlf_postulant;
	}
	
	public String getCv_postulant() {
		return cv_postulant;
	}
	public void setCv_postulant(String cv_postulant) {
		this.cv_postulant = cv_postulant;
	}
	public List<Offre> getOffres_postulant() {
		return offres_postulant;
	}
	public void setOffres_postulant(List<Offre> offres_postulant) {
		this.offres_postulant = offres_postulant;
	}
	
	
	
	
	
	
}
