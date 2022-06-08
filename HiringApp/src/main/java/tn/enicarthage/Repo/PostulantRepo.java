package tn.enicarthage.Repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Model.Postulant;
import tn.enicarthage.Model.Recruteur;

@Repository
public interface PostulantRepo extends JpaRepository <Postulant , Long>{

	void deletePostulantById(Long id);

	Optional<Postulant> findPostulantById(long id);
	
	

}



