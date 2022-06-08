package tn.enicarthage.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.enicarthage.Model.Postulant;
import tn.enicarthage.Model.Recruteur;
import tn.enicarthage.Model.Utilisateur;
import tn.enicarthage.Repo.PostulantRepo;



@Service
public class PostulantService {
	private final PostulantRepo postulantRepo;
	
	@Autowired
	public PostulantService (PostulantRepo postulantRepo) {
		this.postulantRepo=postulantRepo ;
	}
	
	public Postulant addPostulant (Postulant postulant) {
		return postulantRepo.save(postulant);
	}
	
	public List<Postulant> findAllPostulants() {
		return postulantRepo.findAll() ; 
	}
	
	public Postulant findPostulantById (long id) {
		return postulantRepo.findPostulantById(id).orElseThrow(() -> new UserNotFoundException ("User by id "+id+" was not found"));			
		}
	
	public Postulant updatePostulant (Postulant postulant) {
		//Postulant entityPostulant = findById(postulant.getId)
		//entityPostulant.setNom(postulant.getNom_postulant())
		return postulantRepo.save(postulant);
	}
	
	public void deletePostulant (Long id) {
			postulantRepo.deleteById(id);
	}
	

}
