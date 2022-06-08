package tn.enicarthage.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Offre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long offreId ; 
	private String titre_offre ; 
	private String domaine_offre ; 
	private String region_offre ; 
	private String condition_offre ; 

	@Temporal(TemporalType.TIMESTAMP)
    private Date date_offre;
	
	@ManyToMany(mappedBy="offres_postulant")
	private List <Postulant> postulants_offre =new ArrayList <>() ; 
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	
	private Recruteur recruteur;

	public Offre(Long offreId, String titre_offre, String domaine_offre, String region_offre, String condition_offre,
			Date date_offre) {
		super();
		this.offreId = offreId;
		this.titre_offre = titre_offre;
		this.domaine_offre = domaine_offre;
		this.region_offre = region_offre;
		this.condition_offre = condition_offre;
		this.date_offre = date_offre;
	}

	public Offre() {
		super();
	}

	public Long getOffreId() {
		return offreId;
	}

	public void setId_offre(Long offreId) {
		this.offreId = offreId;
	}

	public String getTitre_offre() {
		return titre_offre;
	}

	public void setTitre_offre(String titre_offre) {
		this.titre_offre = titre_offre;
	}

	public String getDomaine_offre() {
		return domaine_offre;
	}

	public void setDomaine_offre(String domaine_offre) {
		this.domaine_offre = domaine_offre;
	}

	public String getRegion_offre() {
		return region_offre;
	}

	public void setRegion_offre(String region_offre) {
		this.region_offre = region_offre;
	}

	public String getCondition_offre() {
		return condition_offre;
	}

	public void setCondition_offre(String condition_offre) {
		this.condition_offre = condition_offre;
	}

	public Date getDate_offre() {
		return date_offre;
	}

	public void setDate_offre(Date date_offre) {
		this.date_offre = date_offre;
	}

	public List<Postulant> getPostulants_offre() {
		return postulants_offre;
	}

	public void setPostulants_offre(List<Postulant> postulants_offre) {
		this.postulants_offre = postulants_offre;
	}

	public Recruteur getRecruteur() {
		return recruteur;
	}

	public void setRecruteur(Recruteur recruteur) {
		this.recruteur = recruteur;
	}


	
	
}
