package tp3.taa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp3.taa.business.Medecin;

@Repository
public interface MedecinDAO extends JpaRepository<Medecin, Long> {

    // AJouter ses propres fonctiond perso

}
