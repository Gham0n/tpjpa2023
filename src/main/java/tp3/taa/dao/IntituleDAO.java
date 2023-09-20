package tp3.taa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tp3.taa.business.intitule.Intitule;

public interface IntituleDAO extends JpaRepository<Intitule, Long> {

}
