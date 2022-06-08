package tn.enicarthage.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.enicarthage.Model.Recruteur;
import tn.enicarthage.Model.Recruteur;
import tn.enicarthage.Model.Utilisateur;
import tn.enicarthage.Repo.RecruteurRepo;



@Service
public class RecruteurService {
	private static RecruteurRepo recruteurRepo;
	
	@Autowired
	public RecruteurService (RecruteurRepo recruteurRepo) {
		this.recruteurRepo=recruteurRepo ;
	}
	
	public Recruteur addRecruteur (Recruteur recruteur) {
		return recruteurRepo.save(recruteur);
	}
	
	public List<Recruteur> findAllRecruteurs() {
		return recruteurRepo.findAll() ; 
	}
	
	public static Recruteur findRecruteurById (long id) {
		return recruteurRepo.findRecruteurById(id).orElseThrow(() -> new UserNotFoundException ("User by id "+id+" was not found"));			
		}
	
	public Recruteur updateRecruteur (Recruteur recruteur) {
		//Recruteur entityRecruteur = findById(recruteur.getId)
		//entityRecruteur.setNom(recruteur.getNom_recruteur())
		return recruteurRepo.save(recruteur);
	}
	
	public void deleteRecruteur (Long id) {
			recruteurRepo.deleteById(id);
	}
	

}
