package tn.enicarthage;

import java.util.List;
import java.util.Optional;

import tn.enicarthage.Model.Recruteur;
import tn.enicarthage.Model.Utilisateur;
import tn.enicarthage.Service.LoginService;
import tn.enicarthage.Service.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("")
public class UtilisateurController {

	private final LoginService LoginService ; 

	@Autowired
	public UtilisateurController(LoginService loginService ) {
		this.LoginService=loginService ;
	
	}
	
	//fonction qui retourne tout les offres dans table offres
	@GetMapping("/login")
	public ResponseEntity<?> LoginIn(@RequestParam(value="pseudoUser") String pseudo , @RequestParam(value="motdepasseUser")  String mdp) 
	{
		
		Utilisateur user =LoginService.findByPseudoUser(pseudo) ;

		if (user.getMotdepasse_user().equals(mdp) ) 
			return new ResponseEntity<> (user , HttpStatus.OK);
		else 
			return new ResponseEntity<> ("wrong" , HttpStatus.OK); 
	}


	
}