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


import tn.enicarthage.Service.PostulantService;
import tn.enicarthage.Model.Postulant;
import tn.enicarthage.Model.Utilisateur;
import tn.enicarthage.Repo.PostulantRepo;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/postulant")
public class PostulantController {

	private final PostulantService postulantService ; 

	
	public PostulantController(PostulantService postulantService) {
		this.postulantService=postulantService ; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Postulant>> getAllPostulants() 
	{
		List<Postulant> postulants =postulantService.findAllPostulants();
		return new ResponseEntity<> (postulants , HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Postulant> getPostulantById(@PathVariable("id") Long id ) 
	{
		Postulant postulant = postulantService.findPostulantById(id);
		return new ResponseEntity<> (postulant, HttpStatus.OK); 
	}
	
	@PostMapping ("/add") 
	public ResponseEntity <Postulant> addPostulant(@RequestBody Postulant postulant) 
	{
		Postulant new_postulant = postulantService.addPostulant(postulant) ; 
		return new ResponseEntity<> (new_postulant , HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping ("/update") 
	public ResponseEntity<Postulant> updatePostulant(@RequestBody Postulant postulant) 
	{
		Postulant updated_postulant = postulantService.updatePostulant(postulant) ; 
		return new ResponseEntity<> (updated_postulant , HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	//@DeleteMapping ("/delete/{id}")
	
	//@RequestMapping(method = RequestMethod.DELETE , value="/delete/{id}")
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deletePostulant(@PathVariable("id") Long id) 
	{
		
		postulantService.deletePostulant(id) ;
		return new ResponseEntity<> (id, HttpStatus.OK);
		
	}
	
	
}
