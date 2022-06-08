package tn.enicarthage.Repo;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Model.Offre;
import tn.enicarthage.Model.Postulant;
import tn.enicarthage.Model.Utilisateur;
@Repository 
@Primary
public interface UtilisateurRepo extends JpaRepository<Utilisateur , Long>
{

	Utilisateur  findUtilisateurByPseudoUser(String pseudoUser);
	
	// Utilisateur findBypseudo(String pseudo_user);
}
