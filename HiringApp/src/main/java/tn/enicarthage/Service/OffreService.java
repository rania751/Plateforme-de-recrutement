
package tn.enicarthage.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.enicarthage.Model.Offre;
import tn.enicarthage.Model.Recruteur;
import tn.enicarthage.Repo.OffreRepo;



@Service
public class OffreService {
	private final OffreRepo offreRepo;
	
	@Autowired
	public OffreService (OffreRepo offreRepo) {
		this.offreRepo=offreRepo ;
	}
	
	public Offre addOffre (Offre offre) {
		return offreRepo.save(offre);
	}
	
	public List<Offre> findAllOffres() {
		return offreRepo.findAll() ; 
	}
	
	public List<Offre> findOffreByRecruteur (Recruteur rec) {
		return offreRepo.findByRecruteur(rec) ; }
	
	public Offre findOffreById (long offreId) {
		return offreRepo.findByOffreId(offreId).orElseThrow(() -> new UserNotFoundException ("User by id "+offreId+" was not found"));	
		}
	
	public Offre updateOffre (Offre offre) {
		return offreRepo.save(offre);
	}
	
	public void deleteOffre (Long offreId) {
			offreRepo.findByOffreId(offreId);
	}
	

}
