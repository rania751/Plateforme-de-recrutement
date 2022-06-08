package tn.enicarthage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import tn.enicarthage.Service.RecruteurService;
import tn.enicarthage.Model.Recruteur;
import tn.enicarthage.Model.Utilisateur;
import tn.enicarthage.Repo.RecruteurRepo;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/recruteur")
public class RecruteurController {

	private final RecruteurService recruteurService ; 
	
	
	public RecruteurController(RecruteurService recruteurService) {
		this.recruteurService=recruteurService ; 
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Recruteur>> getAllRecruteurs() 
	{
		List<Recruteur> recruteurs =recruteurService.findAllRecruteurs();
		return new ResponseEntity<> (recruteurs , HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Recruteur> getRecruteurById(@PathVariable("id") Long id ) 
	{
		Recruteur recruteur = recruteurService.findRecruteurById(id);
		return new ResponseEntity<> (recruteur, HttpStatus.OK); 
	}
	
	@PostMapping ("/add") 
	public ResponseEntity <Recruteur> addRecruteur(@RequestBody Recruteur recruteur) 
	{
		Recruteur new_recruteur = recruteurService.addRecruteur(recruteur) ; 
		return new ResponseEntity<> (new_recruteur , HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping ("/update") 
	public ResponseEntity<Recruteur> updateRecruteur(@RequestBody Recruteur recruteur) 
	{
		Recruteur updated_recruteur = recruteurService.updateRecruteur(recruteur) ; 
		return new ResponseEntity<> (updated_recruteur , HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	//@DeleteMapping ("/delete/{id}")
	
	//@RequestMapping(method = RequestMethod.DELETE , value="/delete/{id}")
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteRecruteur(@PathVariable("id") Long id) 
	{
		
		recruteurService.deleteRecruteur(id) ;
		return new ResponseEntity<> (id, HttpStatus.OK);
		
	}
	
	
}
