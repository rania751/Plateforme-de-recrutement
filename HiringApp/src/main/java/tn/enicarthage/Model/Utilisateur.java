package tn.enicarthage.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="USER")
public class Utilisateur  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false , updatable=false)
	protected Long id ; 

	protected String privilege_user;

	protected String pseudoUser ; 

	protected String motdepasse_user ; 
	
	public Utilisateur(Long id,String privilege_user, String pseudoUser, String motdepasse_user) {
		super();
		this.id = id;
		
		this.pseudoUser = pseudoUser;
		this.motdepasse_user = motdepasse_user;
		this.privilege_user = privilege_user;
	}
	public Utilisateur ( ) {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrivilege_user() {
		return privilege_user;
	}
	public void setPrivilege_user(String privilege_user) {
		this.privilege_user = privilege_user;
	}
	public String getPseudoUser() {
		return pseudoUser;
	}
	public void setPseudoUser(String pseudoUser) {
		this.pseudoUser = pseudoUser;
	}
	public String getMotdepasse_user() {
		return motdepasse_user;
	}
	public void setMotdepasse_user(String motdepasse_user) {
		this.motdepasse_user = motdepasse_user;
	}
	
	
}
