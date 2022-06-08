package tn.enicarthage.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.Model.Administrateur;

@Repository
public interface AdministrateurRepo   extends JpaRepository <Administrateur , Long> {

}
