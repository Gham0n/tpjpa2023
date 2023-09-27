package tp3.taa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tp3.taa.business.RDV;

@Component
@Repository
public interface RDVDAO extends JpaRepository<RDV, Long> {


}
