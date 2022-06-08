package tn.enicarthage.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.Model.Postulant;
import tn.enicarthage.Model.Utilisateur;
import tn.enicarthage.Repo.UtilisateurRepo;

@Service
public class LoginService {
	private final UtilisateurRepo UserRepo ;
	
	@Autowired
	public LoginService (UtilisateurRepo userRepo) {
		this.UserRepo=userRepo ;
	}
	
	public Utilisateur findByPseudoUser (String pseudoUser) {
		return UserRepo.findUtilisateurByPseudoUser(pseudoUser) ;		
		}
}