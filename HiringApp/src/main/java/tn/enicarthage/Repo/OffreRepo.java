package tn.enicarthage.Repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.enicarthage.Model.Offre;
import tn.enicarthage.Model.Recruteur;


public interface OffreRepo extends JpaRepository<Offre , Long>{

	void  deleteByOffreId(Long offreId);

	Optional <Offre> findByOffreId(long offreId);

	List<Offre> findByRecruteur(Recruteur rec); 

}

