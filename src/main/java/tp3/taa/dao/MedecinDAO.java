package tp3.taa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tp3.taa.business.Medecin;

public interface MedecinDAO extends JpaRepository<Medecin, Long> {

    // AJouter ses propres fonctiond perso

}
