package tn.enicarthage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


import tn.enicarthage.Service.OffreService;
import tn.enicarthage.Service.RecruteurService;
import tn.enicarthage.Model.Offre;
import tn.enicarthage.Model.Recruteur;
import tn.enicarthage.Repo.RecruteurRepo;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("")
public class OffreController {

	private final OffreService offreService ; 
	
	public OffreController(OffreService offreService) {
		this.offreService=offreService ; 
	}
	
	//fonction qui retourne tout les offres dans table offres
	@GetMapping("/all")
	public ResponseEntity<List<Offre>> getAllOffres() 
	{
		List<Offre> offres =offreService.findAllOffres();
		return new ResponseEntity<> (offres , HttpStatus.OK); 
	}
	
	//fonction qui retourne les offres d'un recruteur données par son Id 
	@GetMapping("/recruteur/{recruteurId}/all")
	public ResponseEntity<List<Offre>> getAllOffresR(@PathVariable("recruteurId") Long recruteurId) 
	{
		Recruteur rec = RecruteurService.findRecruteurById(recruteurId) ;
		List<Offre> offres =offreService.findOffreByRecruteur(rec);
		return new ResponseEntity<> (offres , HttpStatus.OK); 
	}
	
	//recherche d'un offre qlq by id
	@GetMapping("/find/{offreId}")
	public ResponseEntity<Offre> getOffreById(@PathVariable("offreId") Long offreId ) 
	{
		Offre offre = offreService.findOffreById(offreId);
		return new ResponseEntity<> (offre, HttpStatus.OK); 
	}
	
	//recherche d'un offre d'un recruteur données by id 
	@GetMapping("/recruteur/{recruteurId}/find/{offreId}")
	public ResponseEntity<Offre> getOffreByIdR(@PathVariable("offreId") Long offreId , @PathVariable("recruteurId") Long recruteurId ) 
	{
		Offre offre = null ; 
		Recruteur rec = RecruteurService.findRecruteurById(recruteurId) ;
		ArrayList<Offre> offres = new ArrayList<Offre>();
		offres = (ArrayList<Offre>) offreService.findOffreByRecruteur(rec) ; 
		for (int i=0 ; i< offres.size() ; i++) {
			if ( offres.get(i).getOffreId() == offreId ) 
				 offre = offres.get(i) ;  }
		return new ResponseEntity<> (offre, HttpStatus.OK); 
	}
	
	@PostMapping ("/add") 
	public ResponseEntity <Offre> addOffre(@RequestBody Offre offre) 
	{
		Offre new_offre = offreService.addOffre(offre) ; 
		return new ResponseEntity<> (new_offre , HttpStatus.CREATED);
	} 
	
	//adding an offer for a specific recruteur
	@PostMapping("recruteur/{recruteurId}/add")
    public ResponseEntity<Offre> AddOffre(@PathVariable("recruteurId") Long recruteurId, @RequestBody Offre offre) {
		Offre new_offre = null ; 
    		
		try {
			Recruteur rec = RecruteurService.findRecruteurById(recruteurId) ;
			offre.setRecruteur(rec) ; 
			new_offre = offreService.addOffre(offre) ; 
			
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("there is a problem") ; 
		}
          
		return new ResponseEntity<>(new_offre, HttpStatus.OK);
      
    }
	

	@CrossOrigin(origins = "http://localhost:8080")
	//updating an offer
	@PutMapping ("/update") 
	public ResponseEntity<Offre> updateOffre(@RequestBody Offre offre) 
	{
		Offre updated_offre = offreService.updateOffre(offre) ; 
		return new ResponseEntity<> (updated_offre , HttpStatus.OK);
	}
	
	//updating an offer by a recruteur
	@PutMapping ("recruteur/{recruteurId}/update") 
	public ResponseEntity<Offre> updateOffreR(@RequestBody Offre offre  , @PathVariable("recruteurId") Long recruteurId )
	{
		Offre updated_offre = null ; 
		Recruteur rec = RecruteurService.findRecruteurById(recruteurId) ;
		ArrayList<Offre> offres = new ArrayList<Offre>();
		offres = (ArrayList<Offre>) offreService.findOffreByRecruteur(rec) ; 
		for (int i=0 ; i< offres.size() ; i++) {
			if ( offres.get(i).getOffreId() == offre.getOffreId() ) 
				 {offre = offres.get(i) ; 
				updated_offre=offreService.updateOffre(offre)	; }
			else 
				continue ;
		}
		 
		return new ResponseEntity<> (updated_offre , HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	//@DeleteMapping ("/delete/{offreId}")
	
	//@RequestMapping(method = RequestMethod.DELETE , value="/delete/{offreId}")
	@DeleteMapping(value = "/delete/{offreId}")
	public ResponseEntity<?> deleteOffre(@PathVariable("offreId") Long offreId) 
	{
		
		offreService.deleteOffre(offreId) ;
		return new ResponseEntity<> (offreId, HttpStatus.OK);
		
	}
	
	//deleting by one rec
	@DeleteMapping ("recruteur/{recruteurId}/delete/{offreId}") 
	public ResponseEntity<?> deleteR(@PathVariable("offreId") Long offreId , @PathVariable("recruteurId") Long recruteurId )
	{
		 
		Recruteur rec = RecruteurService.findRecruteurById(recruteurId) ;
		ArrayList<Offre> offres = new ArrayList<Offre>();
		offres = (ArrayList<Offre>) offreService.findOffreByRecruteur(rec) ; 
		for (int i=0 ; i< offres.size() ; i++) {
			if ( offres.get(i).getOffreId() == offreId ) 
				 {offreService.deleteOffre(offreId) ; }
			else 
				continue ;
		}
		 
		return new ResponseEntity<> (offreId, HttpStatus.OK);
	}
	
}
