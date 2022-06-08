package tn.enicarthage.Repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Model.Recruteur;



@Repository
public interface RecruteurRepo extends JpaRepository <Recruteur , Long>{


	void deleteRecruteurById(Long id);

	Optional<Recruteur> findRecruteurById(long id);
}