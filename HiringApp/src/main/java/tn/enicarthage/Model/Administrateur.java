package tn.enicarthage.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USER_ADMIN")
public class Administrateur extends Utilisateur{
	private String nom_admin ; 
	private String prenom_admin ;
	public Administrateur(Long id,String privilege_user,  String pseudoUser, String motdepasse_user, String nom_admin,
			String prenom_admin) {
		super(id, privilege_user, pseudoUser, motdepasse_user);
		this.nom_admin = nom_admin;
		this.prenom_admin = prenom_admin;
	}
	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrateur(Long id,String privilege_user ,  String pseudoUser, String motdepasse_user) {
		super(id, privilege_user, pseudoUser, motdepasse_user);
		// TODO Auto-generated constructor stub
	}
	public String getNom_admin() {
		return nom_admin;
	}
	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}
	public String getPrenom_admin() {
		return prenom_admin;
	}
	public void setPrenom_admin(String prenom_admin) {
		this.prenom_admin = prenom_admin;
	}
	
	
	
}
