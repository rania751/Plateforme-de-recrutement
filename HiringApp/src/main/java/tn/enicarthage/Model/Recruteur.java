package tn.enicarthage.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_RECRUTEUR")
public class Recruteur extends Utilisateur {
	private String nom_recruteur ; 
	private String prenom_recruteur ;
	private String pays_recruteur ;
	private String region_recuteur ; 
	private String fonction_recruteur ; 
	private String numerotlf_recruteur ; 

	
	@OneToMany(mappedBy="recruteur" )
	private List <Offre> offres ;
	
	
	public void offrir_emploi() {
	
	  }

	public Recruteur(Long id, String privilege_user , String pseudoUser, String motdepasse_user, String nom_recruteur,
			String prenom_recruteur, String pays_recruteur, String region_recuteur, String fonction_recruteur,
			String numerotlf_recruteur) {
		//super(id, privilege_user,pseudoUser, motdepasse_user);
		
		this.id=id ; 
		this.privilege_user=privilege_user ; 
		this.pseudoUser = pseudoUser ; 
		this.nom_recruteur = nom_recruteur;
		this.prenom_recruteur = prenom_recruteur;
		this.pays_recruteur = pays_recruteur;
		this.region_recuteur = region_recuteur;
		this.fonction_recruteur = fonction_recruteur;
		this.numerotlf_recruteur = numerotlf_recruteur;
	}

	public Recruteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public Recruteur(Long id, String privilege_user , String pseudoUser, String motdepasse_user) {
		super(id, privilege_user , pseudoUser, motdepasse_user);
		// TODO Auto-generated constructor stub
	}
*/
	public String getNom_recruteur() {
		return nom_recruteur;
	}

	public void setNom_recruteur(String nom_recruteur) {
		this.nom_recruteur = nom_recruteur;
	}

	public String getPrenom_recruteur() {
		return prenom_recruteur;
	}

	public void setPrenom_recruteur(String prenom_recruteur) {
		this.prenom_recruteur = prenom_recruteur;
	}

	public String getPays_recruteur() {
		return pays_recruteur;
	}

	public void setPays_recruteur(String pays_recruteur) {
		this.pays_recruteur = pays_recruteur;
	}

	public String getRegion_recuteur() {
		return region_recuteur;
	}

	public void setRegion_recuteur(String region_recuteur) {
		this.region_recuteur = region_recuteur;
	}

	public String getFonction_recruteur() {
		return fonction_recruteur;
	}

	public void setFonction_recruteur(String fonction_recruteur) {
		this.fonction_recruteur = fonction_recruteur;
	}

	public String getNumerotlf_recruteur() {
		return numerotlf_recruteur;
	}

	public void setNumerotlf_recruteur(String numerotlf_recruteur) {
		this.numerotlf_recruteur = numerotlf_recruteur;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}


	
	
}
